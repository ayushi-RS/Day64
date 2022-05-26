class Solution {
     public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int l = find(parents, equation.charAt(0) - 'a');
                int r = find(parents, equation.charAt(3) - 'a');
                parents[l] = r;
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) != '=') {
                int l = find(parents, equation.charAt(0) - 'a');
                int r = find(parents, equation.charAt(3) - 'a');
                if (l == r) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int[] parents, int elem) {
        if (parents[elem] != elem) {
            return find(parents, parents[elem]);
        }
        return elem;
    }
}