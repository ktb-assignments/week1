public class Worker extends User{
    private int assignedCount;
    private int completeCount;
    private boolean isDone;

    public Worker(String name, int assignedCount) {
        super(name);
        this.assignedCount = assignedCount;
        this.completeCount = 0;
        this.isDone = false;
    }

    public void addTask(int count){
        assignedCount += count;
    };
    public void complete(){
        completeCount++;
        if (assignedCount<=completeCount){
            isDone = true;
        }
    };

    public boolean getIsDone() {
        return isDone;
    }

    @Override
    public void showInfo(){
        double rate = (completeCount * 1.0 )/ assignedCount;
        System.out.printf("""
                [작업자 정보]
                작업자명: %s
                할당 받은 업무량: %d
                완수한 업무량: %d
                작업 진행도: %2f
                """, super.getName(), assignedCount, completeCount, rate);
    };
}
