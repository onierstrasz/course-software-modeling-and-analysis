initialization
from: aString
			calls := ((Character cr split: aString)
				select: #notEmpty)
				collect: [ :each | self createCall: each ]