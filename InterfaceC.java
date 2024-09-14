import EntradaDados.*;
import SaidaDados.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class InterfaceC implements ActionListener {
    private JFrame frame;
    private JFrame previousFrame; //variável para armazenar a janela anterior
    private JButton bInserir, bRemover, bListar, bSair, bSalvar, bAbrir;
    private JTextField nomeField, idadeField, rgField, raField, cursoField, semestreField, qntdField, codigoField, mediaField ,materiaField, salvarField, abrirField;
    private JTextField raRemoverField;

    private JButton jButton1;
    private java.awt.Choice Ialuno;
    private JLabel jLabel1;

    private JTextArea textArea;
    private JScrollPane scrollPane;

    Aluno aluno = null;
    IArmazenadorD armD = new VetorDinDisc();
    int verificar = 0;
    //private static IArmazenador arm = new VetorDin();
    private static IArmazenador arm = new ListaArray();
    private static ArquivoBinario arqBin = new ArquivoBinario();

    /**
     * InterfaceC Construtor
     *
     */
    public InterfaceC() {
        // Carregar cadastros salvos do arquivo binário ao abrir o programa
        //carregarCadastros();
        // Create a new JFrame with a title
        frame = new JFrame("Cadastro");
        // Set the default close operation for the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout manager for the content pane of the JFrame to a BoxLayout
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        // Create 4 JButtons with different labels
        bInserir = new JButton("INSERIR ALUNO");
        bRemover = new JButton("REMOVER ALUNO");
        bListar = new JButton("LISTA DE ALUNOS");
        bSalvar = new JButton("SALVAR ARQUIVO");
        bAbrir = new JButton("ABRIR ARQUIVO");
        bSair = new JButton("SAIR");

        // Add an ActionListener to each JButton
        bInserir.addActionListener(this);
        bRemover.addActionListener(this);
        bListar.addActionListener(this);
        bSalvar.addActionListener(this);
        bAbrir.addActionListener(this);
        bSair.addActionListener(this);

        // Center the buttons in the content pane
        bInserir.setAlignmentX(Component.CENTER_ALIGNMENT);
        bRemover.setAlignmentX(Component.CENTER_ALIGNMENT);
        bListar.setAlignmentX(Component.CENTER_ALIGNMENT);
        bSalvar.setAlignmentX(Component.CENTER_ALIGNMENT);
        bAbrir.setAlignmentX(Component.CENTER_ALIGNMENT);
        bSair.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add space between the buttons
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(bInserir);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(bRemover);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(bListar);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(bSalvar);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(bAbrir);
        contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPane.add(bSair);

        // Set the size of the JFrame and make it visible
        frame.setSize(300, 280);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        previousFrame = frame;// Armazene a janela atual como a janela anterior
    }

    // Define the method that is called when a JButton is clicked
    /**
     * Método actionPerformed
     * Método para lidar com eventos de ação (cliques em botões)
     * @param e Um parâmetro
     */
    public void actionPerformed(ActionEvent e) {
        // Check which JButton was clicked
        if (e.getSource() == bInserir) {
            previousFrame.setVisible(false);
            inserir();
        } else if (e.getSource() == bRemover) {
            previousFrame.setVisible(false);
            remover();
        } else if (e.getSource() == bListar) {
            previousFrame.setVisible(false);
            listar();
        } else if (e.getSource() == bSalvar) {
            previousFrame.setVisible(false);
            salvarCadastros();
        } else if (e.getSource() == bAbrir) {
            previousFrame.setVisible(false);
            carregarCadastros();
        }else if (e.getSource() == bSair) {
            //salvarCadastros();
            if(verificar == 1){
                System.exit(0);
            }
            else{
                previousFrame.setVisible(false);
                avisoSalvar();
            }
            
        }
    }

    // Method to create and show the GUI
    /**
     * Método inserir
     * Método para exibir a interface de inserção de dados de um aluno
     */
    private void inserir() {
        Entrada ent = new Entrada();
        Saida saida = new Saida();

        // Create a new JFrame (main window) with a title
        frame = new JFrame("Inserção");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        frame.setSize(400, 400);
        // Set the layout of the window to a grid layout with 0 rows and 2 columns
        //frame.setLayout(new GridLayout(0, 2));
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Margens entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create text fields to accept user input
        nomeField = new JTextField(10);
        idadeField = new JTextField(10);
        rgField = new JTextField(10);
        raField = new JTextField(10);
        cursoField = new JTextField(10);
        semestreField = new JTextField(10);
        codigoField = new JTextField(10);
        materiaField = new JTextField(10);
        mediaField = new JTextField(10);
        //qntdField = new JTextField(10);

        JButton submitButton = new JButton("ADICIONAR ALUNO");
        JButton exitButton = new JButton("VOLTAR");
        JButton adicionarDiscButton = new JButton("ADICIONAR MAIS DISCIPLINAS");
       
        adicionarDiscButton.setBackground(new Color(50, 200, 20));
        // Create a button to submit the input
        //JButton submitButton = new JButton("ENVIAR");

        // Add an action listener to the button to handle the input when it is submitted
        submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    try{
                        // Get the input from the text fields
                        String nome = nomeField.getText();
                        stringInvalida(nome);
                        contemNumero(nome);
                        int idade = Integer.parseInt(idadeField.getText());
                        idadeInvalida(idade);
                        String rg = rgField.getText();
                        stringInvalida(rg);
                        rgInvalido(rg);
                        String ra = raField.getText();
                        stringInvalida(ra);
                        String curso = cursoField.getText();
                        stringInvalida(curso);
                        int semestre = Integer.parseInt(semestreField.getText());
                        semestreInvalido(semestre);

                        String codigo = codigoField.getText();  
                        //stringInvalida(codigo);

                        String materia = materiaField.getText();
                        //stringInvalida(materia);

                        float media = Float.parseFloat(mediaField.getText());
                        //mediaInvalida(media);
                        Disciplina disc = new Disciplina(codigo, materia, media);
                        boolean ok = armD.adicionar(disc);

                        aluno = new Aluno(nome, idade, rg, ra, curso, armD, semestre);

                        boolean confirma = arm.adicionar(aluno);

                        saida.mostrarStatusI(confirma);

                        frame.setVisible(false); // Oculta a janela de inserção
                        previousFrame.setVisible(true); // Reabre a janela principal
                    }catch(ArrayIndexOutOfBoundsException a){
                        System.out.println("Estouro de array. (" + a.getMessage() + ")");
                    }catch(Exception a){
                        System.out.println(a.getMessage());
                    }
                }
            });

        exitButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });

        adicionarDiscButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String codigo = codigoField.getText();  
                    //stringInvalida(codigo);

                    String materia = materiaField.getText();
                    //stringInvalida(materia);

                    float media = Float.parseFloat(mediaField.getText());
                    //mediaInvalida(media);

                    Disciplina disc = new Disciplina(codigo, materia, media);
                    boolean ok = armD.adicionar(disc);

                    limparCaixas();
                }
            });

        // Adiciona os componentes ao frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("NOME:"), gbc);
        gbc.gridx = 1;
        frame.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("IDADE:"), gbc);
        gbc.gridx = 1;
        frame.add(idadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("RG:"), gbc);
        gbc.gridx = 1;
        frame.add(rgField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("RA:"), gbc);
        gbc.gridx = 1;
        frame.add(raField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(new JLabel("CURSO:"), gbc);
        gbc.gridx = 1;
        frame.add(cursoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(new JLabel("SEMESTRE:"), gbc);
        gbc.gridx = 1;
        frame.add(semestreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(new JLabel("CÓDIGO DA DISCIPLINA:"), gbc);
        gbc.gridx = 1;
        frame.add(codigoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        frame.add(new JLabel("DISCIPLINA:"), gbc);
        gbc.gridx = 1;
        frame.add(materiaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        frame.add(new JLabel("MÉDIA:"), gbc);
        gbc.gridx = 1;
        frame.add(mediaField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        //gbc.gridwidth = 2;
        frame.add(adicionarDiscButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        //gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        //gbc.gridwidth = 1;
        frame.add(exitButton, gbc);

        

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Método remover
     * Método para exibir a interface de remoção de dados de um aluno
     */
    private void remover(){
        Entrada ent = new Entrada();
        Saida saida = new Saida();

        // Create a new JFrame (main window) with a title
        frame = new JFrame("Remoção");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        frame.setSize(650, 100);
        // Set the layout of the window to a grid layout with 0 rows and 2 columns
        frame.setLayout(new GridLayout(0, 2));

        // Create text fields to accept user input
        raRemoverField = new JTextField(10);

        // Create a button to submit the input
        JButton submitButton = new JButton("REMOVER");
        JButton voltarButton = new JButton("VOLTAR");

        // Add an action listener to the button to handle the input when it is submitted
        submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        // Get the input from the text fields
                        String raremover = raRemoverField.getText();
                        stringInvalida(raremover);

                        // Do something with the input
                        boolean result = arm.remover(raremover);
                        saida.mostrarStatusR(result);
                    }catch(ArrayIndexOutOfBoundsException a){
                        System.out.println("Estouro de array. (" + a.getMessage() + ")");
                    }catch(Exception a){
                        System.out.println(a.getMessage());
                    }

                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });
        
            voltarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });

        
        // Add the components to the frame
        frame.add(new JLabel("FORNEÇA O RA DO ALUNO QUE DESEJA REMOVER:"));
        frame.add(raRemoverField);
        frame.add(voltarButton);
        frame.add(submitButton);
        
        Action submitAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitButton.doClick();
                }
            };
        raRemoverField.addActionListener(submitAction);
        // Make the frame visible
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Método listar
     *  Método para exibir a interface da lista de dados de alunos
     */
    private void listar(){
        frame = new JFrame("Lista");
        textArea = new JTextArea(20, 50); // 20 linhas, 50 colunas
        textArea.setEditable(false); // Tornar o JTextArea não editável
        scrollPane = new JScrollPane(textArea);

        JButton exitButton = new JButton("VOLTAR");

        // Add an action listener to the button to handle the input when it is submitted
        exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });

        try{
            String lista = arm.listar();
            textArea.setText(lista); // Define o texto no JTextArea
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Estouro de array. (" + a.getMessage() + ")");
        }catch(Exception a){
            System.out.println(a.getMessage());
        }

        // Painel para o botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(exitButton);

        // Adiciona o JScrollPane e o botão ao frame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        frame.setVisible(true); // Oculta a janela de inserção
        frame.setLocationRelativeTo(null);
    }

    /**
     * Método salvarCadastros
     *  Método para salvar os cadastros em um arquivo binário
     */
    private void salvarCadastros() {
        Entrada ent = new Entrada();
        Saida saida = new Saida();

        // Create a new JFrame (main window) with a title
        frame = new JFrame("Gravação");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        frame.setSize(650, 100);
        // Set the layout of the window to a grid layout with 0 rows and 2 columns
        frame.setLayout(new GridLayout(0, 2));

        // Create text fields to accept user input
        salvarField = new JTextField(10);
        JButton entrarButton = new JButton("SALVAR");
        JButton voltarButton = new JButton("VOLTAR");

        // Add an action listener to the button to handle the input when it is submitted
        entrarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String nomeArq = salvarField.getText();
                    arqBin.gravarObj(arm, nomeArq);
                    System.out.println("Cadastros salvos com sucesso!");
                    verificar = 1;
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });
        // Add the components to the frame
        frame.add(new JLabel("FORNEÇA O NOME DO ARQUIVO PARA SALVAR:"));
        frame.add(salvarField);

        voltarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });
        frame.add(voltarButton);
        frame.add(entrarButton);
    
            Action submitAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    entrarButton.doClick();
                }
            };
        salvarField.addActionListener(submitAction);
        // Make the frame visible
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Método carregarCadastros
     * Método para carregar os cadastros a partir de um arquivo binário
     */
    private void carregarCadastros() {
        Entrada ent = new Entrada();
        Saida saida = new Saida();

        // Create a new JFrame (main window) with a title
        frame = new JFrame("Carregar");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        frame.setSize(650, 100);
        // Set the layout of the window to a grid layout with 0 rows and 2 columns
        frame.setLayout(new GridLayout(0, 2));

        // Create text fields to accept user input
        abrirField = new JTextField(10);

        // Create a button to submit the input
        JButton submitButton = new JButton("CARREGAR");
        JButton voltarButton = new JButton("VOLTAR");

        // Add an action listener to the button to handle the input when it is submitted
        submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nomeArq = abrirField.getText();
                    try (FileInputStream fileIn = new FileInputStream(nomeArq);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
                        // Carregar os dados do arquivo binário
                        Object obj = arqBin.lerObj(nomeArq);;
                        if (obj instanceof IArmazenador) {
                            arm = (IArmazenador) obj;
                            System.out.println("Cadastros carregados com sucesso!");
                        } else {
                            System.out.println("Erro: Objeto lido não é uma instância válida de IArmazenador.");
                        }
                    } catch (IOException a) {
                        System.out.println("Erro ao carregar os cadastros: " + a.getMessage());
                    }
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });
            
            voltarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });

        // Add the components to the frame
        frame.add(new JLabel("FORNEÇA O NOME DO ARQUIVO PARA CARREGAR:"));
        frame.add(abrirField);
        frame.add(voltarButton);
        frame.add(submitButton);
        
         Action submitAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitButton.doClick();
                }
            };
        abrirField.addActionListener(submitAction);
        
        // Make the frame visible
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Método avisoSalvar
     * Método utilizado para avisar ao usuário que ele 
     * não salvou o que foi feito, assim dando a opção 
     * de sair ou voltar para salvar.
     */
    public void avisoSalvar(){
        Entrada ent = new Entrada();
        Saida saida = new Saida();

        // Create a new JFrame (main window) with a title
        frame = new JFrame("Sair");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        frame.setSize(700, 140);
        // Set the layout of the window to a grid layout with 0 rows and 2 columns
        frame.setLayout(new GridLayout(0, 2));

        // Create text fields to accept user input
        abrirField = new JTextField(0);

        // Create a button to submit the input
        JButton submitButton = new JButton("CONTINUAR");
        JButton voltarButton = new JButton("VOLTAR");

        // Add an action listener to the button to handle the input when it is submitted
        submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            
            voltarButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    frame.setVisible(false); // Oculta a janela de inserção
                    previousFrame.setVisible(true); // Reabre a janela principal
                }
            });

        // Add the components to the frame
        frame.add(new JLabel("          Certeza que vocẽ não quer salvar o que foi feito?"));
        frame.add(new JLabel("      Clique CONTINUAR, se tiver certeza que não quer salvar  "));
        //frame.add(abrirField);
        frame.add(voltarButton);
        frame.add(submitButton);
        
         Action submitAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitButton.doClick();
                }
            };
        abrirField.addActionListener(submitAction);
        
        // Make the frame visible
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    /**
     * Método limparCaixas
     * Método para limpar os campos de entrada de dados
     */
    private void limparCaixas(){
        codigoField.setText("");
        mediaField.setText("");
        materiaField.setText("");
    }


    /**
     * Método stringInvalida
     * Metodo para verificar se uma string esta vazia.
     * @param  String
     */
    static void stringInvalida(String x) throws Excecoes{//indica quais excessoes serao utilizadas nesse metodo
        if(x == null || x.equals("")){
            throw new Excecoes("String vazia.");
        } 
    }

    /**
     * Método idadeInvalida
     * Metodo para verificar se a idade e valida.
     * @param  int (idade)
     */
    static void idadeInvalida(int x) throws Excecoes {
        if(x < 17 || x > 95){
            throw new Excecoes("Erro: Idade inválida.");
        }
    }

    /**
     * Método mediaInvalida
     * Metodo para verificar se a media esta etre 0 e 10.
     * @param  float(media)
     */
    static void mediaInvalida(float x) throws Excecoes {
        if(x < 0 || x >10){
            throw new Excecoes("Erro: Média invalido.");
        }
    }

    /**
     * Método semestreInvalido
     * Metodo para verificar se a semestre esta etre 1 e 14.
     * @param  int(semestre)
     */
    static void semestreInvalido(int x) throws Excecoes {
        if(x < 0 || x > 15){
            throw new Excecoes("Erro: Semestre inválido.");
        }
    }

    /**
     * Método contemNumero
     * Metodo para verificar se a string contem numeros.
     * @param  string
     */
    static void contemNumero(String x) throws Excecoes{
        Pattern pattern = Pattern.compile(".*\\d+.*");
        Matcher matcher = pattern.matcher(x);
        boolean ok = matcher.matches();

        if(ok == true){
            throw new Excecoes("Erro: não pode conter números");
        }
    }

    /**
     * Método rgInvalido
     * Metodo para verificar se o RG tem a quantidade correta de caracteres.
     * @param  string(rg)
     */
    static void rgInvalido(String x) throws Excecoes{
        int quantidadeCaracteres = x.length();
        if(quantidadeCaracteres < 7 || quantidadeCaracteres > 10){
            throw new Excecoes("Erro: RG invalido.");
        } 
    }
}
