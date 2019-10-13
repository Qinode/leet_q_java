class SnapshotArray {

    int[] array;
    int snap = -1;
    Map<String, Integer> table = new HashMap<String, Integer>();
    Map<String, Integer> changeSet = new HashMap<String, Integer>();

    public SnapshotArray(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++){
            table.put(String.format("%s-%s", snap, i), 0);
        }
    }

    public void set(int index, int val) {
        array[index] = val;
        changeSet.put(String.format("%s-%s", snap+1, index), val);
    }

    public int snap() {
        this.snap++;
        this.table.putAll(this.changeSet);
        this.changeSet.clear();
        return snap;
    }

    public int get(int index, int snap_id) {
        while (snap_id > -1){
            String key = String.format("%s-%s", snap_id, index);
            snap_id--;
            if (!this.table.containsKey(key)){
                continue;
            }else {
                return table.get(key);
            }
        }
        return 0;
    }
}