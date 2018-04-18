package kladionica.session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kladionica.data.MatchData;
import kladionica.entity.Match;

public class UserManager implements UserManagerLocal{

	@Override
	public String insertUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatetUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCredit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Response getAllMatchesToday() {
		Response response = null;
		List<MatchData>JSONRes = null;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour  = cal.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = cal.get(Calendar.MINUTE);
		String currTime = year + "-" + month + "-" + day + " "+hour+":"+minute;
		String time = year + "-" + month + "-" + day + " 23:59:59";
		@SuppressWarnings("unchecked")
		List<Match> matches = em.createQuery("select m from Match m where time>=:'currTime' and time<=:'time'")
			.setParameter("currTime",currTime)
			.setParameter("time", time)
			.getResultList();
		if (matches.size()!=0) {
			JSONRes = new ArrayList<MatchData>();
			for (Match m : matches) {
				MatchData tmp = new MatchData(m.getAwayOdd(), m.getCity(), m.getEgalOdd(), m.getHomeOdd(), m.getTime(),
					m.getLeague(), m.getTeam1(), m.getTeam2());
				JSONRes.add(tmp);
			}
		}
		response = Response.ok(JSONRes, MediaType.APPLICATION_JSON).build();
		return response;
	}
	
	
}
