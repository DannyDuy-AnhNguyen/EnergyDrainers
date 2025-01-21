using MySql.Data.MySqlClient;
using SerialToDatabase;
using System.IO.Ports;
using System.Text.Json;

class Program
{
    static string receivedDataBuffer = "";
    static bool isInserting = false;
    
    static void Main()
    {
        // Configure the serial port
        SerialPort serialPort = new SerialPort
        {
            PortName = "COM8",      // Replace with your COM port
            BaudRate = 9600,        // Set the baud rate
            Parity = Parity.Space,   // Parity
            DataBits = 8,           // Data bits
            StopBits = StopBits.One, // Stop bits
            Handshake = Handshake.RequestToSend
        };

        // connect to the database
        string connSt = "server=sundrainersmysql.mysql.database.azure.com;user=energydrainersAdmin;database=energydrainers;port=3306;password=SunDrainers!";
        MySqlConnection conn = new MySqlConnection(connSt);
        MySqlCommand cmd = conn.CreateCommand();

        try
        {
            Console.WriteLine("Connecting to MySQL...");
            conn.Open();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString);
        }

        try
        {
            // Open the port
            serialPort.Open();
            Console.WriteLine("Serial port opened. Waiting for data...");

            serialPort.DataReceived += SerialPort_DataReceived;

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
                conn.Close();
            }

        }

       

        static void propInDatabase(SerialResult data)
        {
            try
            {
                isInserting = true;

                Console.WriteLine(data.ToString());
                

            }
            catch (Exception)
            {

                throw;
            }
            finally { isInserting = false;}
            
           
        }

        static void SerialPort_DataReceived(object sender, SerialDataReceivedEventArgs e)
        {
            SerialPort sp = (SerialPort)sender;
            string newData = sp.ReadLine(); // Read incoming data

            try
            {
                SerialResult data = JsonSerializer.Deserialize<SerialResult>(newData);
                if (!isInserting)
                    propInDatabase(data);
                
            }
            catch (Exception ex)
            {

                //Console.WriteLine(ex.ToString());
            }
        }

        static void DataWriter(MySqlCommand cmd, MySqlConnection conn, SerialResult data)
        {
            DateTime date = DateTime.Now;
            string FormDate = date.ToString("yyyy-MM-dd HH:mm:ss"); // format datetime into data MySql can process

            string sql = $"INSERT INTO meting (tijdstip, HOEK_kantelservo, HOEK_draaiservo, LDR_BovenRechts, LDR_BovenLinks, LDR_OnderRechts, LDR_OnderLinks, TrackerID) VALUES ('{FormDate}', '{data.ServoAttitude}', '{data.ServoAzimuth}', '{data.TopRight}', '{data.TopLeft}', '{data.BottomRight}', '{data.BottomLeft}', '1', )";
            cmd = new MySqlCommand(sql, conn);
            cmd.ExecuteNonQuery();
        }
    } 
}
