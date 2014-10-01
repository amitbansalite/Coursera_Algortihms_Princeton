/*************************************************************************
 *  Compilation:  javac SuffixArray.java
 *  Execution:    java SuffixArray < input.txt
 *  
 *  A data type that computes the suffix array of a string.
 *
 *  % java SuffixArray < abra.txt 
 *    i ind lcp rnk  select
 *  ---------------------------
 *    0  11   -   0  !
 *    1  10   0   1  A!
 *    2   7   1   2  ABRA!
 *    3   0   4   3  ABRACADABRA!
 *    4   3   1   4  ACADABRA!
 *    5   5   1   5  ADABRA!
 *    6   8   0   6  BRA!
 *    7   1   3   7  BRACADABRA!
 *    8   4   0   8  CADABRA!
 *    9   6   0   9  DABRA!
 *   10   9   0  10  RA!
 *   11   2   2  11  RACADABRA!
 *
 *   Note: this version uses mergesort. Probably would be faster
 *   with 3-way quicksort.
 *
 *************************************************************************/

public class SuffixArray {
    private final char[] text;
    private final int[] index;   // index[i] = j means text.substring(j) is ith largest suffix
    private final int N;         // number of characters in text

    public SuffixArray(String s) {
        this.text = s.toCharArray();
        this.N    = s.length();
        this.index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;
        sort(index);
    }

    // size of string
    public int length() { return N; }

    // index of ith sorted suffix
    public int index(int i) { return index[i]; }

    // ith sorted suffix
    public String select(int i) {
        return new String(text, index[i], N - index[i]);
    }

    // longest common prefix of suffixes(i) and suffixes(i-1)
    public int lcp(int i) {
        return lcp(index[i], index[i-1]);
    }

    // longest common prefix of text[i..N) and text[j..N)
    private int lcp(int i, int j) {
        // if (i == j) add optimization
        int length = 0;
        while (i < N && j < N) {
            if (text[i] != text[j]) return length;
            i++;
            j++;
            length++;
        }
        return length;
    }

    // number of suffixes strictly less than query
    public int rank(String query) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = compare(query, index[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    } 

    // is query < text[i..N) ?
    private int compare(String query, int i) {
        int M = query.length();
        int j = 0;
        while (i < N && j < M) {
            if (query.charAt(j) != text[i]) return query.charAt(j) - text[i];
            i++;
            j++;

        }
        if (i < N) return -1;
        if (j < M) return +1;
        return 0;
    }

    /*********************************************************************
     *  Mergesort code for suffix sorting.
     *********************************************************************/
    private void merge(int[] src, int[] dst, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];
            else                           dst[k] = src[i++];
        }
    }

    private void sort(int[] src, int[] dst, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);
        merge(src, dst, lo, mid, hi);
    }

    // sort
    public void sort(int[] a) {
        int[] aux = a.clone();
        sort(aux, a, 0, a.length-1);  
    }


    // is text[i..N) < text[j..N) ?
    private boolean less(int i, int j) {
        if (i == j) return false;  // optimization when two suffixes are equal
        while (i < N && j < N) {
            if (text[i] < text[j]) return true;
            if (text[i] > text[j]) return false;
            i++;
            j++;
        }
        return i > j;
    }

    public static void main(String[] args) {
        String s = StdIn.readAll().replaceAll("\n", " ").trim();
        SuffixArray suffix = new SuffixArray(s);

        StdOut.println("  i ind lcp rnk  select");
        StdOut.println("---------------------------------------");
        for (int i = 0; i < s.length(); i++) {
            int index  = suffix.index(i);
            String ith = "\"" + s.substring(index, Math.min(index + 50, s.length())) + "\"";
            int rank = suffix.rank(s.substring(index));
            if (i == 0) {
                StdOut.printf("%3d %3d %3s %3d  %s\n", i, index, "-", rank, ith);
            }
            if (i > 0) {
                int lcp  = suffix.lcp(suffix.index(i), suffix.index(i-1));
                StdOut.printf("%3d %3d %3d %3d  %s\n", i, index, lcp, rank, ith);
            }
        }
    }
}
