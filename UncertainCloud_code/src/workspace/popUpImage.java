package workspace;

/**
 *
 * @author Evi
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class popUpImage extends JFrame{
    
    private ImageIcon image;
    private JLabel lbl = new JLabel();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public popUpImage(){
       this.setUndecorated(true); 
    }
    private void callpopUpImage() {
        
        lbl.setIcon(image);
        getContentPane().add(lbl);
        setSize(image.getIconWidth(), image.getIconHeight());
        int x = (screenSize.width - getSize().width)/2; 
        int y = (screenSize.height - getSize().height)/2;
        setLocation(x, y);
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                setVisible(false);
                image.getImage().flush();
            }
        });
    }
   
    public void call(){
        callpopUpImage();
        setVisible(true);
    }
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
