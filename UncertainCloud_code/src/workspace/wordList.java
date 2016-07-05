package workspace;
/**
 *
 * @author Evi
 */
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import wordcloud.WordFrequency;


public class wordList extends javax.swing.JFrame{
    
    //Variables declaration
    private JTable table;
    private JTable table2;
    private JScrollPane jScrPane1;
    private JScrollPane jScrPane2;
     
     private JButton ok = new JButton("OK");
     private JButton dlt = new JButton("Delete");
     private JButton add = new JButton("Add");
     
     private JMenuBar jMenuBar1 = new JMenuBar();
     private JMenu fileMenu = new JMenu();
     private JMenu helpMenu = new JMenu();
     private List<WordFrequency> wordFrequencies = new ArrayList<>();
     private List<WordFrequency> finalWordFrequencies;
     
     private String wordStr = null;
     private int weightInt = 0;
     private int certInt = 0;
     
     private JFrame frame2 = new JFrame();
    
    Object[] row = new Object[3];
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    
    public wordList(){
       initComponents();

    }
    
    private void initComponents(){
        
      //Set the frame characteristics
       setTitle( "Word List" );
       setSize( 405, 450 );
       setBackground( Color.gray );
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon13.png")));
       setLocation(870,150);
       
       table = new JTable();
       table2 = new JTable();
       jScrPane1 = new JScrollPane(); 
       jScrPane2 = new JScrollPane();
       
       
        Object[] columns = {"Syntax"};
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Example :"},
                {"Text :"}
            },
            new String [] {
                "Syntax :"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
       wordFrequencies.add(new WordFrequency("GavLab",18,255));
       jScrPane1.setViewportView(table);
       model2 = new DefaultTableModel(
            new Object [][] {
                {"GavLab", "18", "255"}
            },
            new String [] {
                "Word","Weight","Certainty (0 - 255)"
            });
        table2.setModel(model2);
        
        TableColumnModel tcm = table2.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(30);
        tcm.getColumn(2).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table2.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        table2.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table2.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
     
        jScrPane2.setViewportView(table2);
        
        fileMenu.setText("File");
        JMenuItem openIt = new JMenuItem("Open text");
        openIt.addActionListener(new openTxt());
        JMenuItem saveTxt = new JMenuItem("Save as txt");
        saveTxt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to save your changes to words.txt?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    saveFile();
                }else if(dialogResult == JOptionPane.NO_OPTION){
                    System.out.println("Press No");
                }
            }
        });
        JMenuItem clearAll = new JMenuItem ("Clear list");
        clearAll.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want"
                        + " to delete all items?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    int rowCount = model2.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        model2.removeRow(i);
                        wordFrequencies.remove(i);
                    }
                }else if(dialogResult == JOptionPane.NO_OPTION){
                    System.out.println("Press No");
                }
            }
        });
        JMenuItem exitIt = new JMenuItem("Exit");
        exitIt.addActionListener(new exitApp1());
        fileMenu.add(openIt);
        fileMenu.add(saveTxt);
        fileMenu.add(clearAll);
        fileMenu.add(exitIt);
        jMenuBar1.add(fileMenu);
        setJMenuBar(jMenuBar1);
        
         ok.addActionListener(new ActionListener(){
            
             @Override
            public void actionPerformed(ActionEvent e){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to save changes?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    saveFile();
                }else if(dialogResult == JOptionPane.NO_OPTION){
                    System.out.println("Press No");
                }
                wordList.this.setVisible(false);
                frame2.setVisible(false);
            }
          });
         
         add.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                
               addWindow();
               
            }
          });
         
         dlt.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table2.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model2.removeRow(i);
                    wordFrequencies.remove(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(dlt)
                        .addGap(18, 18, 18)
                        .addComponent(ok))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrPane1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrPane2, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrPane1, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrPane2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(dlt)
                    .addComponent(add))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }
        
    
    
    private static class exitApp1 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    private class openTxt implements ActionListener {
        public void actionPerformed(ActionEvent e){

            BufferedReader br = null;
            ArrayList rosterList = new ArrayList();
            ArrayList dat2 = new ArrayList();
            
            try{
                
                String a = null;
                int b = 0,c = 0;
                File f = new File("words.txt");
                if(f.exists() && !f.isDirectory()) {
                  br = new BufferedReader(new FileReader("words.txt"));
                  String line = br.readLine();
                  while (line != null ) {
                      rosterList.add(line);
                      String [] rowfields = line.split(" "); 
                      int sum = 0;
                      for (String s : rowfields) {
                          sum += 1;
                          if(sum == 1){
                              a = (String) s;
                          }else if(sum == 2){
                              b = Integer.parseInt(s);
                          }else if(sum == 3){
                              c = Integer.parseInt(s);
                          }
                          dat2.add(s);
                      } 
                      line = br.readLine();
                      addword(a,b,c);
                  }
                }else{
                    PrintWriter writer = new PrintWriter("words.txt", "UTF-8");
                }
            }catch (FileNotFoundException ev){
                ev.printStackTrace();
            }catch (IOException ev){
                ev.printStackTrace();
            }
        }
    }
    private void saveFile(){
        try {
            File file = new File("words.txt");
            PrintWriter os = new PrintWriter(file,"UTF-8");
            for (int row = 0; row < table2.getRowCount(); row++) {
                for (int col = 0; col < table2.getColumnCount(); col++) {
                    if(col == 0){
                        os.print(table2.getValueAt(row, col));
                        os.print(" ");
                    }else if(col == 1){
                        os.print(table2.getValueAt(row, col));
                        os.print(" ");
                    }else if(col == 2){
                        os.println(table2.getValueAt(row, col));
                    }
                }
            }
            os.close();
        } catch (IOException evv) {
            evv.printStackTrace();
        }
    }
    
    private void finalList(){
        finalWordFrequencies = new ArrayList<>();
        String a1 = null;
        int b1 = 0;
        int c1 = 0;
        for (int row = 0; row < table2.getRowCount(); row++) {
            a1 = (String)table2.getValueAt(row, 0);
            b1 = Integer.parseInt((String) table2.getValueAt(row, 1).toString());
            c1 = Integer.parseInt((String) table2.getValueAt(row, 2).toString());
            finalWordFrequencies.add(new WordFrequency(a1,b1,c1));
        }
    }
    
    public void addword(String a1, int b1, int c1){
        
        wordFrequencies.add(new WordFrequency(a1,b1,c1));
        row[0] = a1;
        row[1] = b1;
        row[2] = c1;
        
        //add row to the model
        model2.addRow(row);
    }
    
    public void addWindow(){
        
        JLabel certaintyLabel = new JLabel();
        JTextField certaintyText = new JTextField(8);
        JButton addBtn = new JButton();
        JLabel weightLabel = new JLabel();
        JTextField weightText = new JTextField(8);
        JLabel wordLabel = new JLabel();
        JTextField wordText = new JTextField(8);
        JButton back = new JButton();
        
        frame2.setTitle( "Add a word" );
        frame2.setSize( 280, 280 );
        frame2.setBackground( Color.ORANGE );
        frame2.setLocation(590,150);
       
        wordText.setText("");
        wordLabel.setText("Word:");
        weightLabel.setText("Weight:");
        weightText.setText("");
        certaintyLabel.setText("Certainty(0-255):");
        certaintyText.setText("");

        addBtn.setText("Add");
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wordText.getText().equals("") || weightText.getText().trim().isEmpty() || certaintyText.getText().trim().isEmpty()){
                  JOptionPane.showMessageDialog(frame2,"No data entered - Please try again!" ,"Error",JOptionPane.ERROR_MESSAGE);
                }else{
                   wordStr = wordText.getText();
                   weightInt = Integer.parseInt(weightText.getText().trim());
                   certInt = Integer.parseInt(certaintyText.getText().trim());
                   if (certInt < 0 || certInt > 255){
                       JOptionPane.showMessageDialog(frame2,"The certainty is incorrect - Please type your data again!" ,"Error",JOptionPane.ERROR_MESSAGE);
                       certaintyText.setText("");
                   }else{
                        
                        addword(wordStr, weightInt, certInt);

                        wordText.setText("");
                        weightText.setText("");
                        certaintyText.setText("");
                   }
                }
            }
        });
        
        back.setText("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                frame2.setVisible(false);
            }
        });

        GroupLayout layout = new GroupLayout(frame2.getContentPane());
        frame2.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(certaintyLabel)
                            .addComponent(weightLabel, GroupLayout.Alignment.TRAILING)
                            .addComponent(wordLabel, GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(weightText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(certaintyText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(back)
                                .addGap(82, 82, 82))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(back)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(wordLabel)
                    .addComponent(wordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLabel)
                    .addComponent(weightText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(certaintyLabel)
                    .addComponent(certaintyText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addBtn)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    
       frame2.setVisible(true);
    }

    public List<WordFrequency> getWordFrequencies() {
        return wordFrequencies;
    }

    public List<WordFrequency> getFinalWordFrequencies() {
        finalList();
        return finalWordFrequencies;
    }
    
}