package oob.inteface;

/**
 * 代理模式的测试
 */

interface Network {
    void browse();
}

class Server implements Network {

    @Override
    public void browse() {
        System.out.println("真实服务器进行联网...");
    }
}

class ProxyServer implements Network {
    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public void check() {
        System.out.println("进行联网前的一些检查操作...");
    }

    @Override
    public void browse() {
        check();
        network.browse();
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer ps = new ProxyServer(server);
        ps.browse();
    }
}
