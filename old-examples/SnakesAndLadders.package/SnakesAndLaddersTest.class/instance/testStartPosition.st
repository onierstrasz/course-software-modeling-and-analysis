running
testStartPosition
	self assert: eg lastPosition equals: 12.
	self assert: eg isNotOver.
	self assert: eg currentPlayer equals: jack.
	self assert: eg firstSquare isFirstSquare.
	self assert: eg firstSquare isLastSquare not.
	self assert: eg firstSquare position equals: 1.
	self assert: eg firstSquare isOccupied.
	self assert: (eg at: eg lastPosition) isFirstSquare not.
	self assert: (eg at: eg lastPosition) isLastSquare.
	self assert: (eg at: eg lastPosition) position equals: 12.
	self assert: (eg at: eg lastPosition) isOccupied not.
	self assert: jack name equals: 'Jack'.
	self assert: jill name equals: 'Jill'.
	self assert: jack position equals: 1.
	self assert: jill position equals: 1