package configuracion;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openmuc.openiec61850.BasicDataAttribute;
import org.openmuc.openiec61850.Brcb;
import org.openmuc.openiec61850.ClientAssociation;
import org.openmuc.openiec61850.ClientSap;
import org.openmuc.openiec61850.DataSet;
import org.openmuc.openiec61850.ModelNode;
import org.openmuc.openiec61850.ServerModel;
import org.openmuc.openiec61850.ServiceError;
import org.openmuc.openiec61850.Urcb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gateway.SampleClientOficina;

//import org.openmuc.openiec61850.ClientSap;

public class PanelIec61850 extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -386731185449901198L;
	private int tselLocal1 = 0;
    private int tselLocal2 = 0;
    private int tselRemote1 = 0;
    private int tselRemote2 = 1;
    private JTextField tselLocalField1 = new JTextField();
    private JTextField tselLocalField2 = new JTextField();
    private JTextField tselRemoteField1 = new JTextField();
    private JTextField tselRemoteField2 = new JTextField();  	

	private JLabel lblIp;
	private JTextField inputIp;
    private JTextField inputPort;
    JButton btnAgregarIED = new JButton();
    
    private ClientAssociation association;
    //PanelIec61850 eventHandler = new PanelIec61850();
    private static final Logger logger = LoggerFactory.getLogger(PanelIec61850.class);
    
	/**
	 * Create the panel.
	 */
	public PanelIec61850() {

		
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setVisible(false);
		
		GridBagLayout gbl_panelIec61850 = new GridBagLayout();
		gbl_panelIec61850.columnWidths = new int[]{207, 61, 55, 0};
		gbl_panelIec61850.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelIec61850.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelIec61850.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panelIec61850);
		
		JLabel lblPropiedades = new JLabel("Propiedades");
		lblPropiedades.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblPropiedades = new GridBagConstraints();
		gbc_lblPropiedades.gridwidth = 3;
		gbc_lblPropiedades.insets = new Insets(0, 0, 5, 5);
		gbc_lblPropiedades.gridx = 0;
		gbc_lblPropiedades.gridy = 0;
		gbc_lblPropiedades.weightx = 1;
		add(lblPropiedades, gbc_lblPropiedades);
		
		lblIp = new JLabel("Dirección IP");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.anchor = GridBagConstraints.WEST;
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 0;
		gbc_lblIp.gridy = 2;
		add(lblIp, gbc_lblIp);
		
		inputIp = new JTextField("10.2.28.231");
		GridBagConstraints gbc_inputIp = new GridBagConstraints();
		gbc_inputIp.gridwidth = 2;
		gbc_inputIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputIp.insets = new Insets(0, 0, 5, 5);
		gbc_inputIp.anchor = GridBagConstraints.NORTHWEST;
		gbc_inputIp.gridx = 1;
		gbc_inputIp.gridy = 2;
		add(inputIp, gbc_inputIp);
		inputIp.setColumns(10);
		
		JLabel lblPort = new JLabel("Puerto");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.anchor = GridBagConstraints.WEST;
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 0;
		gbc_lblPort.gridy = 3;
		add(lblPort, gbc_lblPort);
		
		inputPort = new JTextField("102");
		GridBagConstraints gbc_inputPort = new GridBagConstraints();
		gbc_inputPort.gridwidth = 2;
		gbc_inputPort.insets = new Insets(0, 0, 5, 5);
		gbc_inputPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputPort.gridx = 1;
		gbc_inputPort.gridy = 3;
		add(inputPort, gbc_inputPort);
		inputPort.setColumns(10);
		
		//--------------------------------------------------------------------
		JLabel lblTsel = new JLabel("TSelLocal");
		GridBagConstraints gbc_lblTsel = new GridBagConstraints();
		gbc_lblTsel.anchor = GridBagConstraints.WEST;
		gbc_lblTsel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTsel.gridx = 0;
		gbc_lblTsel.gridy = 4;
		add(lblTsel, gbc_lblTsel);		
		
		
	    tselLocalField1 = new JTextField(Integer.toString(tselLocal1));
		GridBagConstraints gbc_inputTsel = new GridBagConstraints();
		gbc_inputTsel.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTsel.insets = new Insets(0, 0, 5, 5);
		gbc_inputTsel.gridx = 1;
		gbc_inputTsel.gridy = 4;
		add(tselLocalField1, gbc_inputTsel);
		
	    tselLocalField2 = new JTextField(Integer.toString(tselLocal2));
		GridBagConstraints gbc_inputTsel2 = new GridBagConstraints();
		gbc_inputTsel2.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTsel2.insets = new Insets(0, 0, 5, 0);
		gbc_inputTsel2.gridx = 2;
		gbc_inputTsel2.gridy = 4;
		add(tselLocalField2, gbc_inputTsel2);
	    
		//--------------------------------------------------------------------
		JLabel lblTselRem = new JLabel("TSelRemoto");
		gbc_lblTsel = new GridBagConstraints();
		gbc_lblTsel.anchor = GridBagConstraints.WEST;
		gbc_lblTsel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTsel.gridx = 0;
		gbc_lblTsel.gridy = 5;
		add(lblTselRem, gbc_lblTsel);		
		
		
		tselRemoteField1 = new JTextField(Integer.toString(tselRemote1));
		gbc_inputTsel = new GridBagConstraints();
		gbc_inputTsel.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTsel.insets = new Insets(0, 0, 5, 5);
		gbc_inputTsel.gridx = 1;
		gbc_inputTsel.gridy = 5;
		add(tselRemoteField1, gbc_inputTsel);
		
		tselRemoteField2 = new JTextField(Integer.toString(tselRemote2));
		gbc_inputTsel2 = new GridBagConstraints();
		gbc_inputTsel2.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputTsel2.insets = new Insets(0, 0, 5, 0);
		gbc_inputTsel2.gridx = 2;
		gbc_inputTsel2.gridy = 5;
		add(tselRemoteField2, gbc_inputTsel2);	    
   		
	    //--------------------------------------------------------------------
		btnAgregarIED = new JButton("Inspeccionar IED");
		btnAgregarIED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					iedInspections();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAgregarIED = new GridBagConstraints();
		gbc_btnAgregarIED.gridwidth = 2;
		gbc_btnAgregarIED.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregarIED.gridx = 1;
		gbc_btnAgregarIED.gridy = 6;		
		add(btnAgregarIED, gbc_btnAgregarIED);		
		
	}
	
    private void iedInspections() throws IOException {
    	System.out.println("Funcion Inspeccionar. IP: "+inputIp.getText()+", Puerto: "+inputPort.getText());
    	
        ClientSap clientSap = new ClientSap();

        InetAddress address = null;
        try {
            address = InetAddress.getByName(inputIp.getText());
        } catch (UnknownHostException e1) {
        	System.out.println("error de ip");
            e1.printStackTrace();
            return;
        }

        int remotePort = 10002;
        try {
            remotePort = Integer.parseInt(inputPort.getText());
            if (remotePort < 1 || remotePort > 0xFFFF) {
                throw new NumberFormatException("port must be in range [1, 65535]");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }  
        
        clientSap.setTSelLocal(getTselLocal());
        clientSap.setTSelRemote(getTselRemote());

        try {
            association = clientSap.associate(address, remotePort, null, null);
        } catch (IOException e) {
            logger.error("Error connecting to server: " + e.getMessage());
            return;
        }

        ServerModel serverModel;
        try {
            serverModel = association.retrieveModel();
            association.getAllDataValues();
        } catch (ServiceError e) {
            logger.error("Service Error requesting model.", e);
            association.close();
            return;
        } catch (IOException e) {
            logger.error("Fatal IOException requesting model.", e);
            return;
        }
        
        System.out.println("Inicio de exploracion del servidor");
        //association.getAllDataValues();
        
        Files file = new Files("getBasicDataAttributes","txt");
        for (BasicDataAttribute bda : serverModel.getBasicDataAttributes()) {
            
        	//System.out.println("BDA: " + bda);
        	file.writeLine(bda.toString());
        }   
        file.closeFile();
        System.out.println("FIN DE EXPLORACION y del archivo");
        
        //Files fileReference = new Files("getReference","txt", serverModel.getReference().toString());
        //fileReference.closeFile();
        
        //Files fileName = new Files("getName","txt", serverModel.getName().toString());
        //fileName.closeFile();
        
        Files fileDataset = new Files("getDataset","txt");
        for (DataSet modelNode : serverModel.getDataSets()) {
			fileDataset.writeLine(modelNode.toString());
		}
        fileDataset.closeFile();
        
        Files fileBrcbs = new Files("getBrcbs", "txt"); 
        for (Brcb modelNode : serverModel.getBrcbs()) {
			fileBrcbs.writeLine(modelNode.toString());
		}
        fileBrcbs.closeFile();
        
        Files fileUrcbs = new Files("getUrcbs", "txt"); 
        for (Urcb modelNode : serverModel.getUrcbs()) {
			fileUrcbs.writeLine(modelNode.toString());
		}
        fileUrcbs.closeFile();
        
        Files fileBrcbEstados2Child = new Files("fileBrcbEstados2Child", "txt");
        Brcb brcb = serverModel.getBrcb("UC_SSAACTRL/LLN0.brcbESTADOS2");
        for (ModelNode modelNode : brcb.getChildren()) {
			fileBrcbEstados2Child.writeLine(modelNode.toString());
		}
        fileBrcbEstados2Child.closeFile();
        
        Files fileDatasetEstados2Child = new Files("fileDatasetEstados2Child", "txt");
        DataSet dataset = serverModel.getDataSet("UC_SSAACTRL/LLN0.ESTADOS2");
        for (ModelNode modelNode : dataset) {
        	fileDatasetEstados2Child.writeLine(modelNode.toString());
		}
        fileDatasetEstados2Child.closeFile();
        
    }	
    
    public byte[] getTselLocal() {
        tselLocal1 = parseTextField(tselLocalField1, tselLocal1);
        tselLocal2 = parseTextField(tselLocalField2, tselLocal2);    	
        return new byte[] { (byte) tselLocal1, (byte) tselLocal2 };
    }
    
    public byte[] getTselRemote() {
        tselLocal1 = parseTextField(tselRemoteField1, tselRemote1);
        tselLocal2 = parseTextField(tselRemoteField2, tselRemote2);    	
        return new byte[] { (byte) tselLocal1, (byte) tselLocal2 };
    }
    
    private int parseTextField(JTextField field, int oldValue) {
        int value = oldValue;
        try {
            int newValue = Integer.parseInt(field.getText());
            if (newValue >= 0 && newValue <= 255) {
                value = newValue;
            }
        } catch (NumberFormatException e) {
            return oldValue;
        }
        return value;
    }
		
    
}
