package Methods;

/**
 * Created by Александр on 08.04.14.
 */
public class SuperMethod implements Method{
    private Method delegate;

    public void setDelegate(Method delegate){
        this.delegate = delegate;
    }

    public SuperMethod(Method delegate){
        this.delegate = delegate;
    }

    @Override
    public void encrypt() {
        delegate.encrypt();
    }

    @Override
    public void decrypt() {
        delegate.decrypt();
    }
}
