package modelo;

import Bean.receta;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Publisher {
    
    private static Publisher miSingleton;
    private Publisher(){}
    public static Publisher getpublisher(){
        if(miSingleton == null){
            miSingleton = new Publisher();
        }
        return miSingleton;
    }
    
    private final static String QUEUE_NAME = "cola10";
    
    public boolean EnviarReceta( receta Obj_receta) throws Exception {
        
        boolean flag = false;
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        
        try{
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
            String message = Obj_receta.getFecha()+","+Obj_receta.getMed()+","+Obj_receta.getNombre()+","+Obj_receta.getApellido()+","+Obj_receta.getDni()+","+Obj_receta.getMedicamento()+","+Obj_receta.getCantidad()+","+Obj_receta.getIndicaciones();
            
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            
            System.out.println(" [x] Sent '" + message + "'");
            flag = true;
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
