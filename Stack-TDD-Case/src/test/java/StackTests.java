import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StackTests {
    @Test
    public void it_should_return_zero_if_stack_is_empty(){
        //Arrange
        StackImpl sut = new StackImpl(6);

        //Act
        int size = sut.count();

        //Assert
        assertEquals(size , 0);
    }

    @Test
    public void it_should_push_to_stack_given_integer(){
        //Arrange
        StackImpl sut = new StackImpl(6);
        int oldSize = sut.count();

        //Act
        sut.pushToStack(2);

        //Assert
        assertEquals(sut.count() , (oldSize + 1));
    }

    @Test
    public void it_should_return_the_last_element_when_peek_executed(){
        //Arrange
        StackImpl sut = new StackImpl(6);
        sut.pushToStack(2);
        sut.pushToStack(6);

        //Act
        int peekValue = sut.peek();

        //Assert
        assertEquals(peekValue, 6);
    }

    @Test
    public void it_should_return_empty_exception_on_peek_when_stack_is_empty(){
        //Arrange
        StackImpl sut = new StackImpl(6);

        //Act

        //Assert
        Assertions.assertThrows(EmptyStackException.class, () -> {
                    sut.peek();
        }
        );
    }

    @Test
    public void it_should_remove_last_element_when_pop_executed(){
        //Arrange
        StackImpl sut = new StackImpl(6);
        sut.pushToStack(2);
        sut.pushToStack(6);

        //Act
        sut.pop();

        //Assert
        assertEquals(1, sut.count());
        assertEquals(2, sut.peek());
    }

    @Test
    public void it_should_return_empty_exception_on_pop_executed(){
        //Arrange
        StackImpl sut = new StackImpl(6);

        //Act

        //Assert
        Assertions.assertThrows(EmptyStackException.class, () -> {
            sut.pop();});
    }

    @Test
    public void it_should_return_exception_when_stack_limit_exceeded(){
        //Arrange
        StackImpl sut = new StackImpl(6);
        sut.pushToStack(2);
        sut.pushToStack(2);
        sut.pushToStack(2);
        sut.pushToStack(2);
        sut.pushToStack(2);
        sut.pushToStack(2);

        //Act
        //Assert
        Assertions.assertThrows(StackSizeLimitException.class, () -> { sut.pushToStack(3);});
    }
}
