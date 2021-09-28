playing
playToEnd
	"SnakesAndLadders example playToEnd"

	"Transcript closeAllViews."
	(Transcript dependents select: #isSystemWindow) do: #close.
	Transcript open.
	Transcript
		show: self asString;
		cr;
		cr.
	[self isNotOver] whileTrue: 
			[Transcript
				show: self playOneMove asString;
				cr.
			Transcript
				show: self asString;
				cr;
				cr]