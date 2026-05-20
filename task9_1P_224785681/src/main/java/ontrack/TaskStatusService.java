package ontrack;

public class TaskStatusService {

	public String getTaskStatus(String status) {
		
        if (status == null || status.trim().isEmpty()) {
            return "Invalid task status.";
        }
 
        switch (status.trim().toUpperCase()) {
            case "READY_FOR_FEEDBACK":
                return "Task is submitted and ready for feedback.";
            case "NOT_STARTED":
                return "Task has not been started yet.";
            case "WORKING_ON_IT":
                return "Task is currently being worked on.";
            case "NEED_HELP":
                return "Task requires assistance from tutor.";
            case "REDO":
                return "Task needs to be redone.";
            case "FEEDBACK_EXCEEDED":
                return "Task has exceeded the feedback limit.";
            case "RESUBMIT":
                return "Task requires resubmission.";
            case "DISCUSS":
                return "Task requires discussion with tutor.";
            case "COMPLETE":
                return "Task is complete.";
            case "FAIL":
                return "Task has failed.";
            case "ASSESS_IN_PORTFOLIO":
                return "Task will be assessed in portfolio.";
            case "ATTENTION_REQUIRED":
                return "Task requires immediate attention.";
            case "TIME_EXCEEDED":
                return "Task has exceeded the time limit.";
            case "DEMONSTRATE":
                return "Task requires a demonstration.";
            default:
                return "Invalid task status.";
        }
    }
	
}
