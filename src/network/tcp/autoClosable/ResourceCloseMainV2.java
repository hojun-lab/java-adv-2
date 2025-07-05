package network.tcp.autoClosable;

public class ResourceCloseMainV2 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resourceV1 = null;
        ResourceV1 resourceV2 = null;

        try {
            resourceV1 = new ResourceV1("resourceV1");
            resourceV2 = new ResourceV1("resourceV2");
            resourceV1.call();
            resourceV2.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            System.out.println("자원 정리");

            if (resourceV2 != null) {
                resourceV2.closeEx();
            }
            if (resourceV1 != null) {
                resourceV1.closeEx();
            }
        }
    }
}
