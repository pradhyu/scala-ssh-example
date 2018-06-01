import com.decodified.scalassh._
import org.bouncycastle.jce.provider._

object Main extends App {
  // using host config
  SSH("localhost", HostConfigProvider.fromHostConfig(
    new HostConfig( new PasswordLogin("root",PasswordProducer.fromString( "root")), hostName= "localhost", port= 2222))) {
    client =>
    client.exec("ls /").map { result =>
      println("Result:\n" + result.stdOutAsString())
    }
    client.close()
  }

  SSH("localhost", HostConfigProvider.fromHostConfig(
    new HostConfig( new PasswordLogin("root",PasswordProducer.fromString( "root")), hostName= "localhost", port= 2222))) {
    client =>
    client.exec("touch ~/zyz")
    client.exec("ls ~/").map {result =>
      println ("result: \n" + result.stdOutAsString())
    }
    client.close()

  }
}
