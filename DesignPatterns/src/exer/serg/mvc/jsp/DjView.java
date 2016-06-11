package exer.serg.mvc.jsp;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exer.serg.mvc.BeatModel;

public class DjView extends HttpServlet {

	private static final String DJ_VIEW_JSP_TAG = "/jsp/DjView.jsp";
	private static final String INCREASE_TAG = "increase";
	private static final String DECREASE_TAG = "decrease";
	private static final String SET_TAG = "set";
	private static final String BPM_TAG = "bpm";
	private static final String BEAT_MODEL_TAG = "beatModel";
	private static final String OFF_TAG = "off";
	private static final String ON_TAG = "on";

	private static final long serialVersionUID = -3352470623810263230L;

	@Override
	public void init() throws ServletException {
		BeatModel beatModel = new BeatModel();
		beatModel.initialize();
		getServletContext().setAttribute(BEAT_MODEL_TAG, beatModel);
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		BeatModel beatModel = (BeatModel) getServletContext().getAttribute(BEAT_MODEL_TAG);
		String bpm = req.getParameter(BPM_TAG);
		if (bpm == null) {
			bpm = beatModel.getBpm() + "";
		}

		String set = req.getParameter(SET_TAG);
		if (set != null) {
			int bpmNumber = 90;
			bpmNumber = Integer.parseInt(bpm);
			beatModel.setBpm(bpmNumber);
		}
		
		String decrease = req.getParameter(DECREASE_TAG);
		if (decrease != null) {
			beatModel.setBpm(beatModel.getBpm() - 1);
		}
	
		String increase = req.getParameter(INCREASE_TAG);
		if (increase != null) {
			beatModel.setBpm(beatModel.getBpm() + 1);
		}
		
		String on = req.getParameter(ON_TAG);
		if (on != null) {
			beatModel.on();
		}
		
		String off = req.getParameter(OFF_TAG);
		if (off != null) {
			beatModel.off();
		}
		
		req.setAttribute(BEAT_MODEL_TAG, beatModel);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(DJ_VIEW_JSP_TAG);
		
		dispatcher.forward(req, resp);
	
	}
	
	

}
