-- them 1 match , update diem , update goal cua 2 doi 
create trigger tr_insertMatch
on Matchs
for INSERT 
as
begin 
	select im.MatchsID, im.homeClubID, im.awayClubID, im.goalOfHomeClub, im.goalOfAwayClub
	from inserted im

	--update home clubs
	--win
	update Clubs
	set Clubs.numberOfWinMatch = 
		( case WHEN i.goalOfHomeClub > i.goalOfAwayClub THEN Clubs.numberOfWinMatch + 1 
			else Clubs.numberOfWinMatch
		end ), 
		Clubs.numberOfLoseMatch = 
		( case WHEN i.goalOfHomeClub < i.goalOfAwayClub THEN Clubs.numberOfLoseMatch + 1 
			else Clubs.numberOfLoseMatch
		end ),
		Clubs.numberOfDrawMatch = 
		( case WHEN i.goalOfHomeClub = i.goalOfAwayClub THEN Clubs.numberOfDrawMatch + 1 
			else Clubs.numberOfDrawMatch
		end )
	from inserted i
	where Clubs.clubID = (
			select i.homeClubID
			from inserted i
		)

		update Clubs
	set Clubs.numberOfWinMatch = 
		( case WHEN i.goalOfHomeClub < i.goalOfAwayClub THEN Clubs.numberOfWinMatch + 1 
			else Clubs.numberOfWinMatch
		end ), 
		Clubs.numberOfLoseMatch = 
		( case WHEN i.goalOfHomeClub > i.goalOfAwayClub THEN Clubs.numberOfLoseMatch + 1 
			else Clubs.numberOfLoseMatch
		end ),
		Clubs.numberOfDrawMatch = 
		( case WHEN i.goalOfHomeClub = i.goalOfAwayClub THEN Clubs.numberOfDrawMatch + 1 
			else Clubs.numberOfDrawMatch
		end )
	from inserted i
	where Clubs.clubID = (
			select i.awayClubID
			from inserted i
		)
end
