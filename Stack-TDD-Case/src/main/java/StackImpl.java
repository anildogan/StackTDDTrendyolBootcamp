import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackImpl {


    private ArrayList<Integer> stack = new ArrayList<Integer>();
    private int maxSize ;

    public StackImpl(int maxSize) {
        this.maxSize = maxSize;
    }

    public int count() {
        return stack.size();
    }



    public void pushToStack(int i) {
        if(stack.size() >= this.maxSize) {
            throw new StackSizeLimitException();
        }
        stack.add(i);
    }

    public int peek() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1 );
    }

    public void pop() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }

        stack.remove(stack.size() -1 );
    }

}
