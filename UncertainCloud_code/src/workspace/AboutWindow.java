package workspace;
/**
 *
 * @author Evi
 */
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutWindow extends javax.swing.JFrame{
                      
    private JLabel copyright;
    private JButton okBtn;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JPanel jPanel1;
    private JLabel imageBark;
    
    String contact = "evi.xandri@gmail.com";
  
    
    public AboutWindow(){
        initComponents();
    }
    
     private void initComponents() {

        copyright = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        okBtn = new JButton();
        jPanel1 = new JPanel();
        imageBark = new JLabel();

        setTitle("About");
        setSize(352,390);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon13.png")));
        setLocationRelativeTo(null);

        copyright.setText("© Created by Xandri Evi version 1.0.0");
        
        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("UncertainCloud is an application for generating\n"
                + "\"tag clouds\" from a text document that you can\n"
                + "create. The clouds give greater prominence to\n"
                + "words with bigger weight, which you set in the\n"
                + "file, including uncertainty information. \n\n"
                + "It was created in April 2016 in collaboration \n"
                + "with GavLab.\n"
                + "To report a problem, ask a question or make a\n"
                + "feature request, you can send email directly to\n"
                + contact);
        
        jScrollPane1.setViewportView(jTextArea1);

        okBtn.setText("OK");
        okBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               setVisible(false); 
            }
        });
        
        imageBark.setIcon(new ImageIcon(getClass().getResource("/123.png")));
        imageBark.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                imageBarkMouseClicked(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageBark, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(copyright))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageBark, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyright))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
     private void imageBarkMouseClicked(java.awt.event.MouseEvent evt) {                                       
        try{
            String url = "http://gav.uop.gr/";
            Desktop.getDesktop().browse(URI.create(url));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }  
}
