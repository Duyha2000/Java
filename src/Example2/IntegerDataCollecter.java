package Example2;

// abstract -> extends
// interface -> implements
public class IntegerDataCollecter implements DataCollector<Integer> {


    @Override
    public void addItem(Integer item) {
        
    }

    @Override
    public Integer getItem(int index) {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
