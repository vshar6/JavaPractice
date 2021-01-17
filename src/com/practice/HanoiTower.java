
import java.util.Stack;

public class HanoiTower {

    private Stack<Integer> disks;
    int index;

    public HanoiTower(Stack<Integer> disks, int index) {
        this.disks=disks;
        this.index=index;
    }

    public void moveTop(HanoiTower t) {
        int disc = this.disks.pop();
        t.add(disc);
    }

    public void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
        moveDisks(n-1,buffer,destination);
        moveTop(destination);
        moveDisks(n-1, destination, this );
    }

    public void add(int d) {
        if(!disks.isEmpty() && disks.peek()<-d) {
            System.out.println("Error in placing disk:"+d);
        } else {
            disks.push(d);
        }

    }
}

