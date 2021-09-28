running
testExample
	self assert: jack name equals: 'Jack'.
	self assert: jill name equals: 'Jill'.
	self assert: jack position equals: 1.
	self assert: jill position equals: 1.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jack position equals: 2.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 2.
	eg playOneMove.
	self assert: jill position equals: 7.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 3.
	eg playOneMove.
	self assert: jack position equals: 5.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jill position equals: 7.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 2.
	eg playOneMove.
	self assert: jack position equals: 1.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jill position equals: 12.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 6.
	eg playOneMove.
	self assert: jack position equals: 7.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jill position equals: 13.
	self assert: eg isOver