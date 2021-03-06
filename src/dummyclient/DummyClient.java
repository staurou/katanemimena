package dummyclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import javax.swing.JFormattedTextField;
import javax.swing.table.AbstractTableModel;
import static ssn.Constants.DATE_FORMAT;
import ssn.models.*;

public class DummyClient extends javax.swing.JFrame {

    
    
    private final ResultsModel resultsModel = new ResultsModel();
    
    public DummyClient() {
        initComponents();
        latitudeFrom.setValue(40.6);
        longitudeFrom.setValue(-75.0);
        latitudeTo.setValue(40.7);
        longitudeTo.setValue(-74.0);
        try {
            timeFrom.setValue(DATE_FORMAT.parse("2012-04-03 00:00:00"));
            timeTo.setValue(DATE_FORMAT.parse("2012-04-03 23:59:59"));
        } catch (ParseException ex) {}
    }

    static class ResultsModel extends AbstractTableModel {
        private static final String[] COLUMNS = {"Poi", "Poi Name", "Latitude",
        "Longitude", "Checkin Count"};
        
        private PoiStats[] data = {};
        
        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            PoiStats poi = data[rowIndex];
            switch (columnIndex) {
                case 0: return poi.getPoi();
                case 1: return poi.getPoiName();
                case 2: return poi.getLatitude();
                case 3: return poi.getLongitude();
                case 4: return poi.getCount();
            }
            return null;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        public void setData(PoiStats[] data) {
            this.data = data;
            fireTableDataChanged();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        formPane = new javax.swing.JPanel();
        latitudeFromLabel = new javax.swing.JLabel();
        latitudeFrom = new JFormattedTextField( NumberFormat.getNumberInstance());
        ;
        longitudeFromLabel = new javax.swing.JLabel();
        longitudeFrom = new JFormattedTextField( NumberFormat.getNumberInstance());
        ;
        latitudeToLabel = new javax.swing.JLabel();
        latitudeTo = new JFormattedTextField( NumberFormat.getNumberInstance());
        ;
        longitudeToLabel = new javax.swing.JLabel();
        longitudeTo = new JFormattedTextField( NumberFormat.getNumberInstance());
        ;
        timeFromLabel = new javax.swing.JLabel();
        timeFrom = new javax.swing.JFormattedTextField();
        timeToLabel = new javax.swing.JLabel();
        timeTo = new javax.swing.JFormattedTextField();
        timeFromHintLabel = new javax.swing.JLabel();
        timeToHintLabel = new javax.swing.JLabel();
        hostLabel = new javax.swing.JLabel();
        host = new javax.swing.JFormattedTextField();
        portLabel = new javax.swing.JLabel();
        port = new javax.swing.JFormattedTextField();
        search = new javax.swing.JButton();
        durationLabel = new javax.swing.JLabel();
        countDuplicatePhotos = new javax.swing.JCheckBox();
        resultsPane = new javax.swing.JPanel();
        resultsScroll = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Distributed Top Checkins");

        formPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 25, 3, 20));
        formPane.setOpaque(false);
        formPane.setLayout(new java.awt.GridBagLayout());

        latitudeFromLabel.setText("Latitude From");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        formPane.add(latitudeFromLabel, gridBagConstraints);

        latitudeFrom.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        formPane.add(latitudeFrom, gridBagConstraints);

        longitudeFromLabel.setText("LongitudeFrom");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        formPane.add(longitudeFromLabel, gridBagConstraints);

        longitudeFrom.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        formPane.add(longitudeFrom, gridBagConstraints);

        latitudeToLabel.setText("Latitude To");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        formPane.add(latitudeToLabel, gridBagConstraints);

        latitudeTo.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        formPane.add(latitudeTo, gridBagConstraints);

        longitudeToLabel.setText("LongitudeTo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        formPane.add(longitudeToLabel, gridBagConstraints);

        longitudeTo.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        formPane.add(longitudeTo, gridBagConstraints);

        timeFromLabel.setText("Time From");
        timeFromLabel.setToolTipText("yyyy-MM-dd HH:mm:ss");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        formPane.add(timeFromLabel, gridBagConstraints);

        timeFrom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))));
        timeFrom.setToolTipText("yyyy-MM-dd HH:mm:ss");
        timeFrom.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        formPane.add(timeFrom, gridBagConstraints);

        timeToLabel.setText("Time To");
        timeToLabel.setToolTipText("yyyy-MM-dd HH:mm:ss");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        formPane.add(timeToLabel, gridBagConstraints);

        timeTo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))));
        timeTo.setToolTipText("yyyy-MM-dd HH:mm:ss");
        timeTo.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        formPane.add(timeTo, gridBagConstraints);

        timeFromHintLabel.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        timeFromHintLabel.setForeground(new java.awt.Color(113, 113, 113));
        timeFromHintLabel.setText("yyyy-MM-dd HH:mm:ss");
        timeFromHintLabel.setToolTipText("yyyy-MM-dd HH:mm:ss");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        formPane.add(timeFromHintLabel, gridBagConstraints);

        timeToHintLabel.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        timeToHintLabel.setForeground(new java.awt.Color(113, 113, 113));
        timeToHintLabel.setText("yyyy-MM-dd HH:mm:ss");
        timeToHintLabel.setToolTipText("yyyy-MM-dd HH:mm:ss");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        formPane.add(timeToHintLabel, gridBagConstraints);

        hostLabel.setText("Host");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 98;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        formPane.add(hostLabel, gridBagConstraints);

        host.setFormatterFactory(null);
        host.setText("localhost");
        host.setMinimumSize(new java.awt.Dimension(100, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 98;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        formPane.add(host, gridBagConstraints);

        portLabel.setText("Port");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 98;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        formPane.add(portLabel, gridBagConstraints);

        port.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        port.setToolTipText("");
        port.setMinimumSize(new java.awt.Dimension(100, 27));
        port.setValue(25697);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 98;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        formPane.add(port, gridBagConstraints);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        formPane.add(search, gridBagConstraints);

        durationLabel.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        durationLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPane.add(durationLabel, gridBagConstraints);

        countDuplicatePhotos.setText("Count Duplicate Photos");
        countDuplicatePhotos.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 99;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        formPane.add(countDuplicatePhotos, gridBagConstraints);

        getContentPane().add(formPane, java.awt.BorderLayout.NORTH);

        resultsPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 4, 5));
        resultsPane.setLayout(new java.awt.BorderLayout());

        resultsTable.setModel(resultsModel);
        resultsTable.setFillsViewportHeight(true);
        resultsScroll.setViewportView(resultsTable);

        resultsPane.add(resultsScroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(resultsPane, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(779, 538));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            LocationStatsRequest req = new LocationStatsRequest();
            req.setLatitudeFrom(((Number) latitudeFrom.getValue()).doubleValue());
            req.setLongitudeFrom(((Number) longitudeFrom.getValue()).doubleValue());
            req.setLatitudeTo(((Number) latitudeTo.getValue()).doubleValue());
            req.setLongitudeTo(((Number) longitudeTo.getValue()).doubleValue());
            req.setTimeFrom((Date) timeFrom.getValue());
            req.setTimeTo((Date) timeTo.getValue());
            req.setCountDuplicatePhotos(countDuplicatePhotos.isSelected());
            
            Socket s = new Socket(host.getText(), ((Number) port.getValue()).intValue());
            long start = System.currentTimeMillis();
            OutputStream out = s.getOutputStream();
            System.out.println("Req "+Request.fromObject("locationStats", req).toString());
            out.write(Request.fromObject("locationStats", req).toString().getBytes());
//            out.close();
            out.flush();
            s.shutdownOutput();
            InputStream in = s.getInputStream();
            ObjectMapper m = new ObjectMapper();
            PoiStats[] responce = m.readValue(in, PoiStats[].class);
            durationLabel.setText(((System.currentTimeMillis()-start)/1000.0)+"s");
            resultsModel.setData(responce);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DummyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DummyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DummyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DummyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DummyClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox countDuplicatePhotos;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JPanel formPane;
    private javax.swing.JFormattedTextField host;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JFormattedTextField latitudeFrom;
    private javax.swing.JLabel latitudeFromLabel;
    private javax.swing.JFormattedTextField latitudeTo;
    private javax.swing.JLabel latitudeToLabel;
    private javax.swing.JFormattedTextField longitudeFrom;
    private javax.swing.JLabel longitudeFromLabel;
    private javax.swing.JFormattedTextField longitudeTo;
    private javax.swing.JLabel longitudeToLabel;
    private javax.swing.JFormattedTextField port;
    private javax.swing.JLabel portLabel;
    private javax.swing.JPanel resultsPane;
    private javax.swing.JScrollPane resultsScroll;
    private javax.swing.JTable resultsTable;
    private javax.swing.JButton search;
    private javax.swing.JFormattedTextField timeFrom;
    private javax.swing.JLabel timeFromHintLabel;
    private javax.swing.JLabel timeFromLabel;
    private javax.swing.JFormattedTextField timeTo;
    private javax.swing.JLabel timeToHintLabel;
    private javax.swing.JLabel timeToLabel;
    // End of variables declaration//GEN-END:variables
}
