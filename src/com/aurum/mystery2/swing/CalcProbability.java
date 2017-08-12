package com.aurum.mystery2.swing;

public class CalcProbability extends javax.swing.JFrame {
    public CalcProbability() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLevel = new javax.swing.JLabel();
        lblFactor = new javax.swing.JLabel();
        spnLevel = new javax.swing.JSpinner();
        spnFactor = new javax.swing.JSpinner();
        chkFriendBow = new javax.swing.JCheckBox();
        btnCalc = new javax.swing.JButton();
        txtResult = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recruitment probabilty calculator");
        setIconImage(com.aurum.mystery2.Main.icon);
        setResizable(false);

        lblLevel.setText("Player level");

        lblFactor.setText("Enemy factor");

        spnLevel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        spnFactor.setModel(new javax.swing.SpinnerNumberModel((short)0, null, null, (short)1));

        chkFriendBow.setText("Has Friend Bow");

        btnCalc.setText("Calculate");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        txtResult.setEditable(false);
        txtResult.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtResult.setText("0.0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFriendBow)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnCalc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtResult))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLevel)
                                .addComponent(lblFactor))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(spnFactor)
                                .addComponent(spnLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel)
                    .addComponent(spnLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFactor)
                    .addComponent(spnFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkFriendBow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalc)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        int level = (int) spnLevel.getValue();
        
        int levelfactor = 0;
        if (level >= 30 && level <= 39) levelfactor = 50;
        else if (level >= 30 && level <= 39) levelfactor = 50;
        else if (level >= 40 && level <= 49) levelfactor = 75;
        else if (level >= 50 && level <= 59) levelfactor = 100;
        else if (level >= 60 && level <= 69) levelfactor = 125;
        else if (level >= 70 && level <= 79) levelfactor = 150;
        else if (level >= 80 && level <= 89) levelfactor = 175;
        else if (level >= 90 && level <= 100) levelfactor = 240;
        
        float sum = (levelfactor + (short) spnFactor.getValue() + (chkFriendBow.isSelected() ? 100F : 0F)) / 10F;
        txtResult.setText(Float.toString(sum) + '%');
    }//GEN-LAST:event_btnCalcActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JCheckBox chkFriendBow;
    private javax.swing.JLabel lblFactor;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JSpinner spnFactor;
    private javax.swing.JSpinner spnLevel;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}