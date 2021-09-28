initialization
createCall: callString
	| fields callee owner call |
	fields := $| split: callString.
	self assert: fields size = 5.
	self assert: (fields at: 1) size = 0.
	callee := self getMethod: (fields at: 2).
	owner := self getClass: (fields at: 3).
	callee owner: owner.
	call := Call new.
	call	callee: callee;
		args: (fields at:4);
		caller: (fields at: 5).
	callee addCall: call.
	^ call