
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DisplayItems extends javax.swing.JFrame {

    //Creating DisplayItems form in DisplayItems class
    public DisplayItems() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel5.setText("Display Item Details");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of the Item", "Type of meal course", "Price of the item"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 370, 120));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 0));
        jButton1.setText("Display Item Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 0));
        jButton2.setText("Clear ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 70, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 153, 0));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 70, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 153, 0));
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 60, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Others.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Clear Button
    To clear the table in the form */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel Restaurant = (DefaultTableModel) jTable1.getModel();
        int rows = Restaurant.getRowCount(); //get the count of the total number of rows
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                Restaurant.removeRow(0); //remove a row
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /* Back Button
    To go back to the previous form */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Item().setVisible(true); //Making Item class visible
    }//GEN-LAST:event_jButton3ActionPerformed

    //Exit Button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0); //Exiting the Restaurant application
    }//GEN-LAST:event_jButton4ActionPerformed

    /* Display Button
    To display row(s) in Restaurant Table */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //To retrive the table 
        DefaultTableModel Restaurant = (DefaultTableModel) jTable1.getModel();
        //try clause
        try {
            Class.forName("java.sql.DriverManager"); //loading driver class
            //connecting to database
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "donna");
            //creating statement object to execute SQL statements to database
            Statement stmt = (Statement) con.createStatement();
            //SQL statement to be executed
            String query = "select * from Restaurant;"; //selecting all records from restaurant table
            //Execute SQL statement
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String Name = rs.getString("Name"); 
                String Type = rs.getString("Type"); 
                String Price = rs.getString("Price"); 
                //Add a row
                Restaurant.addRow(new Object[]{Name, Type, Price});
            }
        } //catch clause
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage()); //error message
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        // Creating and displaying the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            //Running the form
            public void run() {
                new DisplayItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
