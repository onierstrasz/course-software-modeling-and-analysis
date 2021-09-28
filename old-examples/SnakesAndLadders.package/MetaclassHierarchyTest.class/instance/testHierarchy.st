running
testHierarchy
	"The class hierarchy"

	self assert: SnakeSquare superclass equals: BoardSquare.
	self assert: BoardSquare superclass equals: Object.
	self assert: Object superclass superclass equals: nil.
	"The parallel metaclass hierarchy"
	self assert: SnakeSquare class name equals: 'SnakeSquare class'.
	self assert: SnakeSquare class superclass equals: BoardSquare class.
	self assert: BoardSquare class superclass equals: Object class.
	self assert: Object class superclass superclass equals: Class.
	self assert: Class superclass equals: ClassDescription.
	self assert: ClassDescription superclass equals: Behavior.
	self assert: Behavior superclass equals: Object.
	"The Metaclass hierarchy"
	self assert: SnakeSquare class class equals: Metaclass.
	self assert: BoardSquare class class equals: Metaclass.
	self assert: Object class class equals: Metaclass.
	self assert: Class class class equals: Metaclass.
	self assert: ClassDescription class class equals: Metaclass.
	self assert: Behavior class class equals: Metaclass.
	self assert: Metaclass superclass equals: ClassDescription.
	"The fixpoint"
	self assert: Metaclass class class equals: Metaclass
