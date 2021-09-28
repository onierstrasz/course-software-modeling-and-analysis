running
testExample
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 1.
	eg playOneMove.
	self assert: jack position equals: 6.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jill position equals: 1.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jack position equals: 5.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 4.
	eg playOneMove.
	self assert: jill position equals: 1.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 6.
	eg playOneMove.
	self assert: jack position equals: 5.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 6.
	eg playOneMove.
	self assert: jill position equals: 9.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jack position equals: 10.
	self assert: eg currentPlayer equals: jill.
	loadedDie roll: 5.
	eg playOneMove.
	self assert: jill position equals: 1.
	self assert: eg currentPlayer equals: jack.
	loadedDie roll: 2.
	eg playOneMove.
	self assert: jack position equals: 12.
	self assert: eg isOver