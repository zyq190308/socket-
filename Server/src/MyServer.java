import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class MyServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			final ServerSocket server = new ServerSocket(12345);
			System.out.println("服务器已经启动--"+new Date());

			new Thread(){
				public void run() {
					
					while(true){
						Socket socket = null;
						try {
							socket = server.accept();
							System.out.println("客户端信息:"+socket);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				};
			}.start();
			
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
