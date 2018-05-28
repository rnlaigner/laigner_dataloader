package laigner_dataloader;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class Project 
{

	public Project() 
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		
		String filedb = args[0];

		try {
            /**
             * Initialize the Kettle Enviornment
             */
            KettleEnvironment.init();

            /**
             * Create a trans object to properly assign the ktr metadata.
             * 
             * @filedb: The ktr file path to be executed.
             * 
             */
            TransMeta metadata = new TransMeta(filedb);
            Trans trans = new Trans(metadata);

            // Execute the transformation
            trans.execute(null);
            trans.waitUntilFinished();

            // checking for errors
            if (trans.getErrors() > 0) 
            {
                System.out.println("Erroruting Transformation");
            }

        } catch (KettleException e) 
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

}
