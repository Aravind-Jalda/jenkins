pipeline{
    agent any
    // tools {nodejs "node"}
        stages{
            stage("oebrowserextension_db_backup")
            {
                steps{
                    script{
                    sh 'ssh  ovaledge@192.168.1.85 sudo systemctl stop tomcat'
                    echo 'tomcat stopped'
                    sh 'ssh  ovaledge@192.168.1.85 sh /home/ovaledge/database_backup/db_dump.sh'
                    echo 'db buckup completed'
                    sh 'ssh  ovaledge@192.168.1.85 sudo systemctl start tomcat'
                    echo 'tomcat started'
                    }
                }    
            } 
        }   
}
