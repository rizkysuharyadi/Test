package model;
// Generated May 17, 2017 8:45:27 AM by Hibernate Tools 4.3.1



/**
 * ProcessStages generated by hbm2java
 */
public class ProcessStages  implements java.io.Serializable {


     private ProcessStagesId id;
     private Processes processes;
     private String name;
     private float time;

    public ProcessStages() {
    }

    public ProcessStages(ProcessStagesId id, Processes processes, String name, float time) {
       this.id = id;
       this.processes = processes;
       this.name = name;
       this.time = time;
    }
   
    public ProcessStagesId getId() {
        return this.id;
    }
    
    public void setId(ProcessStagesId id) {
        this.id = id;
    }
    public Processes getProcesses() {
        return this.processes;
    }
    
    public void setProcesses(Processes processes) {
        this.processes = processes;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public float getTime() {
        return this.time;
    }
    
    public void setTime(float time) {
        this.time = time;
    }




}


