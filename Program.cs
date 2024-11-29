using System;
using System.IO.Ports;

class Program
{
    static void Main()
    {
        // Configure the serial port
        SerialPort serialPort = new SerialPort
        {
            PortName = "COM6",      // Replace with your COM port
            BaudRate = 115200,        // Set the baud rate
            Parity = Parity.None,   // Parity
            DataBits = 8,           // Data bits
            StopBits = StopBits.One // Stop bits
        };

        try
        {
            // Open the port
            serialPort.Open();
            Console.WriteLine("Serial port opened. Waiting for data...");

            // Set up a DataReceived event handler
            serialPort.DataReceived += (sender, e) =>
            {
                string data = serialPort.ReadExisting(); // Read incoming data
                data = data.Trim(); // Remove unnecessary whitespace

                if (!string.IsNullOrEmpty(data)) // Check if data is valid
                {
                    Console.WriteLine($"Data received: {data}");
                }

                serialPort.DiscardInBuffer(); // Clear the buffer
            };

            Console.WriteLine("Press any key to close...");
            Console.ReadKey();
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
        finally
        {
            // Close the port
            if (serialPort.IsOpen)
            {
                serialPort.Close();
                Console.WriteLine("Serial port closed.");
            }
        }
    }
}
