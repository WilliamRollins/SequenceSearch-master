package edu.gcccd.csis.p1;


public class SequenceSearchImpl extends SequenceSearch {

    private String[] S1 = new String[500];
    //ArrayList<String> S1 = new ArrayList<String>();
    private int i; //index of startTag
    private int k; //index of endTag
    private String startTag;
    private String endTag;
    private String tagged;
    private String source;

    SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
        startTag = start;
        endTag = end;
        source = content;
    }

    @Override
    public String[] getAllTaggedSequences() {
        int j = 0;
        String temp;
        if (startTag.equals(endTag)) {
            do {
                if (-1 != (i = source.indexOf(startTag))) {
                    source = source.substring(i + startTag.length(), source.length());
                    if (-1 != (k = source.indexOf(endTag))) ;
                    if (i != k)
                        tagged = source.substring(0, k);
                    S1[j] = tagged;
                    temp = source.substring(k + startTag.length());
                    source = temp;
                    j++;
                }
            } while (i != -1);
        } else {
            do {
                if (-1 != (i = source.indexOf(startTag))) ;
                if (-1 != (k = source.indexOf(endTag, i))) ;
                if (i < k) {
                    tagged = source.substring(i + 1, k);
                    S1[j] = tagged;
                    temp = source.substring(k);
                    source = temp;
                    j++;
                }
            } while (i != -1);
        }
        int size = 0;
        for (String aS1 : S1) {
            if (aS1 == null) break;
            size++;
        }
        String[] S2 = new String[size];
        for (int k = 0; k < S2.length; k++) {
            if (S1[k] == null) {
                return S2;
            }
            S2[k] = S1[k];
        }
        return S2;
    }

    @Override
    public String getLongestTaggedSequence() {
        String longestStr = null;
        int maxLength = 0;
        String temp;
        do {
            if (-1 != (i = source.indexOf(startTag))) ;
            if (-1 != (k = source.indexOf(endTag, i))) ;
            if (i < k) {
                tagged = source.substring(i + startTag.length(), k);
                if (tagged.length() >= maxLength) {
                    longestStr = tagged;
                    maxLength = tagged.length();
                }
                temp = source.substring(k + endTag.length());
                source = temp;
            }
        } while (i != -1);
        return longestStr;
    }

    @Override
    public String displayStringArray() {
        int j = 0;
        String temp;
        String sa = "";
        if (startTag.equals(endTag)) {
            do {
                if (-1 != (i = source.indexOf(startTag))) ;
                source = source.substring(i + startTag.length(), source.length());
                if (-1 != (k = source.indexOf(endTag))) ;
                if (i < k) {
                    tagged = source.substring(0, k);
                    S1[j] = tagged;
                    temp = source.substring(k);
                    source = temp;
                    j++;
                }
            } while (i != -1);
        } else {
            do {
                i = source.indexOf(startTag);
                if (i != -1) {
                    k = source.indexOf(endTag, i);
                    if (k != -1) {
                        if (i < k) {
                            tagged = source.substring(i + 1, k);
                            System.out.println(tagged);
                            S1[j] = tagged;
                            System.out.println(S1[j]);

                            temp = source.substring(k);
                            source = temp;
                            j++;
                        }
                    }
                }
            } while (i != -1);
        }
        for (String aS1 : S1) {
            if (aS1 == null) return sa;
            sa = sa.concat(aS1 + " : " + aS1.length() + "\n");
        }
        return sa;
    }

    @Override
    public String toString() {
        String tags_removed = content;
        String temp;
        do {
            i = source.indexOf(startTag);
            if (-1 != (k = source.indexOf(endTag, i))) {
                tagged = source.substring(i + startTag.length(), k);
                String tagged_1 = source.substring(i, k + endTag.length());
                temp = tags_removed.replace(tagged_1, tagged);
                tags_removed = temp;
                source = tags_removed;
            }
        } while (i != -1);
        return tags_removed;
    }
}