package client;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import eventos.OuvinteStatusClient;
import eventos.Status;
import java.awt.Color;
import java.io.IOException;

public class FrmJogo extends JFrame {
    private JogoDaVelhaClient client;
    private List<JLabel> lacunas;

    public FrmJogo(){
        initComponents();

        lacunas = new ArrayList<JLabel>();
        client = new JogoDaVelhaClient();

        for(JLabel label : lacunas){
            label.setText("");
        }

        Toolkit tool = Toolkit.getDefaultToolkit();
        int x = (tool.getScreenSize().width - this.getWidth()) / 2;
        int y = (tool.getScreenSize().height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    private void iniciar() {
        this.iniciar("locahost");
    }
    
    public void iniciar(String host) {
        for(Component c : this.getContentPane().getComponents()){
            if(c.getName() != null && c.getName().startsWith("lacuna")){
                final JLabel label = (JLabel) c;
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                lacunas.add(label);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent evt){
                        if(evt.getButton() == MouseEvent.BUTTON1 && label.isEnabled()){
                            jogar(lacunas.indexOf(label));
                        }
                    }
                });
            }
        }

        client.addOuvinteStatus(new OuvinteStatusClient() {
            @Override
            public void mudouEstadoJogo(Status statusJogo) {
                lacunas.get(statusJogo.getPosicaoPressionada()).setText(statusJogo.getJogadorCorrente());
                for (JLabel label : lacunas) {
                    label.setText(statusJogo.getPosicao(lacunas.indexOf(label)));
                }

                lblStatus.setText("Jogador Corrente: " + statusJogo.getJogadorCorrente());
            }

            @Override
            public void conectou() {
                
            }

            @Override
            public void acabouJogo(Status statusJogo) {
                JOptionPane.showMessageDialog(null, "O jogador " + (statusJogo.getJogadorCorrente().equals("X") ? "O" : "X") + " ganhou!",
                        "Ganhou", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void posicaoOcupada(String posicao) {
                JOptionPane.showMessageDialog(null, "A posicao " + posicao +" está ocupada. Jogue novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            @Override
            public void atualizarMensagem(String msg) {
                lblStatus.setText(msg);
            }

            @Override
            public void seuTurno() {
                trocarEstadoCampos(true);
            }

            @Override
            public void acabouTurno() {
                trocarEstadoCampos(false);
            }

            @Override
            public void seuJogadorEh(String jogador) {
                setTitle(">> " + jogador);
            }
        });
        
        client.iniciar(host);
    }

    private void jogar(Integer posicao){
        try{
            client.jogar(posicao);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private void trocarEstadoCampos(boolean habilitar){
        for (JLabel label : lacunas) {
            label.setBackground(habilitar ? Color.WHITE : Color.GRAY);
            label.setEnabled(habilitar);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lacuna1 = new javax.swing.JLabel();
        lacuna2 = new javax.swing.JLabel();
        lacuna3 = new javax.swing.JLabel();
        lacuna6 = new javax.swing.JLabel();
        lacuna4 = new javax.swing.JLabel();
        lacuna5 = new javax.swing.JLabel();
        lacuna9 = new javax.swing.JLabel();
        lacuna7 = new javax.swing.JLabel();
        lacuna8 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".:: JDaVelha");
        setResizable(false);

        lacuna1.setBackground(new java.awt.Color(204, 204, 204));
        lacuna1.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna1.setName("lacuna1"); // NOI18N
        lacuna1.setOpaque(true);
        lacuna1.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna2.setBackground(new java.awt.Color(204, 204, 204));
        lacuna2.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna2.setName("lacuna2"); // NOI18N
        lacuna2.setOpaque(true);
        lacuna2.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna3.setBackground(new java.awt.Color(204, 204, 204));
        lacuna3.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna3.setName("lacuna3"); // NOI18N
        lacuna3.setOpaque(true);
        lacuna3.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna6.setBackground(new java.awt.Color(204, 204, 204));
        lacuna6.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna6.setName("lacuna6"); // NOI18N
        lacuna6.setOpaque(true);
        lacuna6.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna4.setBackground(new java.awt.Color(204, 204, 204));
        lacuna4.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna4.setName("lacuna4"); // NOI18N
        lacuna4.setOpaque(true);
        lacuna4.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna5.setBackground(new java.awt.Color(204, 204, 204));
        lacuna5.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna5.setName("lacuna5"); // NOI18N
        lacuna5.setOpaque(true);
        lacuna5.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna9.setBackground(new java.awt.Color(204, 204, 204));
        lacuna9.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna9.setName("lacuna9"); // NOI18N
        lacuna9.setOpaque(true);
        lacuna9.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna7.setBackground(new java.awt.Color(204, 204, 204));
        lacuna7.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna7.setName("lacuna7"); // NOI18N
        lacuna7.setOpaque(true);
        lacuna7.setPreferredSize(new java.awt.Dimension(50, 50));

        lacuna8.setBackground(new java.awt.Color(204, 204, 204));
        lacuna8.setFont(new java.awt.Font("Dialog", 1, 24));
        lacuna8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lacuna8.setName("lacuna8"); // NOI18N
        lacuna8.setOpaque(true);
        lacuna8.setPreferredSize(new java.awt.Dimension(50, 50));

        lblStatus.setFont(new java.awt.Font("Dialog", 0, 12));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStatus.setText("Iniciando...");
        lblStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lacuna1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacuna2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacuna3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lacuna4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacuna5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacuna6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lacuna7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacuna8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lacuna9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lacuna3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lacuna2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lacuna1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lacuna6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lacuna5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lacuna4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lacuna9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lacuna8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lacuna7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void newClient(String host) {
        FrmJogo janela = new FrmJogo();
        janela.setVisible(true);
        janela.iniciar(host);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lacuna1;
    private javax.swing.JLabel lacuna2;
    private javax.swing.JLabel lacuna3;
    private javax.swing.JLabel lacuna4;
    private javax.swing.JLabel lacuna5;
    private javax.swing.JLabel lacuna6;
    private javax.swing.JLabel lacuna7;
    private javax.swing.JLabel lacuna8;
    private javax.swing.JLabel lacuna9;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables

}
