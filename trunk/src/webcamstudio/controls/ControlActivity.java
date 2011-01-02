/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ControlActivity.java
 *
 * Created on 2010-01-12, 23:53:43
 */

package webcamstudio.controls;

import webcamstudio.components.SourceListener;
import webcamstudio.sources.VideoSource;

/**
 *
 * @author pballeux
 */
public class ControlActivity extends javax.swing.JPanel implements Controls{
    private String label="";
    private VideoSource source = null;
    private SourceListener listener=null;
    /** Creates new form ControlActivity */
    public ControlActivity(VideoSource source) {
        initComponents();
        this.source=source;
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio.Languages");
        label = bundle.getString("ACTIVITY");
        sliderThreshold.setValue(source.getActivityDetection());
        chkEnableActivityDetection.setSelected(source.getActivityDetection()>0);
        sliderThreshold.setEnabled(chkEnableActivityDetection.isSelected());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkEnableActivityDetection = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        sliderThreshold = new javax.swing.JSlider();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        chkEnableActivityDetection.setText(bundle.getString("ENABLEACTIVITYDETECTION")); // NOI18N
        chkEnableActivityDetection.setName("chkEnableActivityDetection"); // NOI18N
        chkEnableActivityDetection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnableActivityDetectionActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("THRESHOLD")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        sliderThreshold.setPaintLabels(true);
        sliderThreshold.setPaintTicks(true);
        sliderThreshold.setEnabled(false);
        sliderThreshold.setName("sliderThreshold"); // NOI18N
        sliderThreshold.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderThresholdStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkEnableActivityDetection)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderThreshold, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkEnableActivityDetection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(sliderThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(204, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkEnableActivityDetectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnableActivityDetectionActionPerformed
        sliderThreshold.setEnabled(chkEnableActivityDetection.isSelected());
        if (chkEnableActivityDetection.isSelected()){
            source.setActivityDetection(sliderThreshold.getValue());
        }
        else {
            source.setActivityDetection(0);
        }
    }//GEN-LAST:event_chkEnableActivityDetectionActionPerformed

    private void sliderThresholdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderThresholdStateChanged
        source.setActivityDetection(sliderThreshold.getValue());
    }//GEN-LAST:event_sliderThresholdStateChanged

    @Override
    public String getLabel() {
        return label;
    }
    @Override
    public void removeControl() {
        source=null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkEnableActivityDetection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider sliderThreshold;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setListener(SourceListener l) {
        listener=l;
    }

}
