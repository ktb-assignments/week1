import java.util.Map;

public class IBWorker extends Worker {
    public static final Map<String, Integer> recommendBoxList
            = Map.of(
            "phoneCase", 1,
            "cup", 2,
            "snack", 3
    );

    public IBWorker(String name, int assignedCount) {
        super(name, assignedCount);
    }

    public int getRecommendBoxNumber(String productName) {
        if (!recommendBoxList.containsKey(productName)) {
            throw new IllegalArgumentException("포장할 수 없습니다.");
        }
        return recommendBoxList.get(productName);
    }

    public boolean completePackaging(String productName, int boxNumber) {
        if (!recommendBoxList.containsKey(productName)) {
            throw new IllegalArgumentException("포장할 수 없습니다.");
        }
        if (recommendBoxList.get(productName) == boxNumber) {
            return true;
        }
        return false;
    }
}
