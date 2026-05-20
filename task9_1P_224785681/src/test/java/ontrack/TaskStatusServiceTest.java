package ontrack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskStatusServiceTest {

	 private TaskStatusService service;
	 
	    @Before
	    public void setUp() {
	        service = new TaskStatusService();
	    }
	 
	 
	    @Test
	    public void testCompleteStatus() {
	        assertEquals("Task is complete.", service.getTaskStatus("COMPLETE"));
	    }
	 
	    @Test
	    public void testReadyForFeedbackStatus() {
	        assertEquals("Task is submitted and ready for feedback.", service.getTaskStatus("READY_FOR_FEEDBACK"));
	    }
	 
	    @Test
	    public void testResubmitStatus() {
	        assertEquals("Task requires resubmission.", service.getTaskStatus("RESUBMIT"));
	    }
	 
	    @Test
	    public void testDiscussStatus() {
	        assertEquals("Task requires discussion with tutor.", service.getTaskStatus("DISCUSS"));
	    }
	 
	    @Test
	    public void testFailStatus() {
	        assertEquals("Task has failed.", service.getTaskStatus("FAIL"));
	    }
	 
	    @Test
	    public void testNeedHelpStatus() {
	        assertEquals("Task requires assistance from tutor.", service.getTaskStatus("NEED_HELP"));
	    }
	 
	    @Test
	    public void testWorkingOnItStatus() {
	        assertEquals("Task is currently being worked on.", service.getTaskStatus("WORKING_ON_IT"));
	    }
	 
	    @Test
	    public void testDemonstrateStatus() {
	        assertEquals("Task requires a demonstration.", service.getTaskStatus("DEMONSTRATE"));
	    }
	 
	    @Test
	    public void testNotStartedStatus() {
	        assertEquals("Task has not been started yet.", service.getTaskStatus("NOT_STARTED"));
	    }
	 
	    // ── Edge / boundary case tests ────────────────────────────────────────────
	 
	    @Test
	    public void testNullStatusReturnsInvalid() {
	        assertEquals("Invalid task status.", service.getTaskStatus(null));
	    }
	 
	    @Test
	    public void testEmptyStatusReturnsInvalid() {
	        assertEquals("Invalid task status.", service.getTaskStatus(""));
	    }
	 
	    @Test
	    public void testUnknownStatusReturnsInvalid() {
	        assertEquals("Invalid task status.", service.getTaskStatus("UNKNOWN"));
	    }
	   
}
