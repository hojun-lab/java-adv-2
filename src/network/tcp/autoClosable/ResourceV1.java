package network.tcp.autoClosable;

public class ResourceV1 {
    private String name;

    public ResourceV1(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println(name + " call");
    }

    public void callEx() throws CallException {
        System.out.println(name + " call ex");
        throw new CallException(name + " ex");
    }

    public void close() {
        System.out.println(name + " close");
    }

    public void closeEx() throws CloseException {
        System.out.println(name + " close ex");
        throw new CloseException(name + " ex");
    }
}
