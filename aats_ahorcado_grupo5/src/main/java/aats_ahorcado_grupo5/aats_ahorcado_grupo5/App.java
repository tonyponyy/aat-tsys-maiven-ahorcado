package aats_ahorcado_grupo5.aats_ahorcado_grupo5;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			vista_ahorcado frame = new vista_ahorcado();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
