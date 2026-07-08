/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package absensiRFID.serial;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
/**
 *
 * @author ADVAN
 */
public class SerialPortManager {

    private SerialPort serialPort;
    private SerialDataHandler dataHandler;

    public boolean connect(String portName) {

        serialPort = SerialPort.getCommPort(portName);

        serialPort.setBaudRate(115200);
        serialPort.setNumDataBits(8);
        serialPort.setNumStopBits(SerialPort.ONE_STOP_BIT);
        serialPort.setParity(SerialPort.NO_PARITY);

        if (serialPort.openPort()) {

            System.out.println("Serial Connected");

            startListening();

            return true;

        } else {

            System.out.println("Gagal membuka port");

            return false;
        }

    }

    public void disconnect() {

        if (serialPort != null && serialPort.isOpen()) {
            serialPort.closePort();
        }

    }

    public boolean isConnected() {
        return serialPort != null && serialPort.isOpen();
    }

    public void sendData(String data) {

        if (isConnected()) {
            serialPort.writeBytes(data.getBytes(), data.length());
        }

    }

    private void startListening() {

        serialPort.addDataListener(new SerialPortDataListener() {

            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {

                byte[] buffer = new byte[serialPort.bytesAvailable()];

                int numRead = serialPort.readBytes(buffer, buffer.length);

                if (numRead > 0) {

                    String uid = new String(buffer).trim();

                    if (dataHandler != null && !uid.isEmpty()) {
                        dataHandler.onDataReceived(uid);
                    }

                }

            }

        });

    }

    public void setDataHandler(SerialDataHandler handler) {
        this.dataHandler = handler;
    }

}
