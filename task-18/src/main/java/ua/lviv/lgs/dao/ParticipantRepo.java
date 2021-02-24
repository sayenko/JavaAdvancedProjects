package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {
	
	private List<Participant> participants = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		Participant participant = new Participant();
		participant.setId(1);
		participant.setName("Participant_1");
		participant.setEmail("participant_1@gmail.com");
		participant.setLevel(Level.L1);
		participant.setPrimarySkill("Participant_1 Primary Skill");
		
		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Participant_2");
		participant2.setEmail("participant_2@gmail.com");
		participant2.setLevel(Level.L2);
		participant2.setPrimarySkill("Participant_2 Primary Skill");
		
		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Participant_3");
		participant3.setEmail("participant_3@gmail.com");
		participant3.setLevel(Level.L3);
		participant3.setPrimarySkill("Participant_3 Primary Skill");
		
		participants.add(participant);
		participants.add(participant2);
		participants.add(participant3);
	}
	
	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(participant -> participant.getId() == id).findFirst().get();
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int bookIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(bookIndex, participantToUpdate);
		}
		else {
			int maxId = 0;
			for (Participant p : participants) {
				if(p.getId()>maxId) maxId = p.getId();
			}
			participant.setId(maxId+1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
	
	public Level[] getLevels() {
		return Level.values();
	}
	
}
