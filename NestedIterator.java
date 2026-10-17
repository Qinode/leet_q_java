/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private int pos = 0;
    private List<Integer> data;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.data = this.flatten(nestedList);
    }

    @Override
    public Integer next() {
        Integer i = this.data.get(this.pos);
        this.pos++;
        return i;
    }

    @Override
    public boolean hasNext() {
        return this.pos < this.data.size();
    }
    
    private List<Integer> flatten(List<NestedInteger> nl){
        List<Integer> temp = new ArrayList<Integer>();
        for (NestedInteger ni: nl){
            if(ni.isInteger()){
                temp.add(ni.getInteger());
            }else{
                temp.addAll(this.flatten(ni.getList()));
            }
        }
        return temp;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */