package com.github.wdn.coding2017.jvm.cmd;


import com.github.wdn.coding2017.jvm.clz.ClassFile;
import com.github.wdn.coding2017.jvm.constant.ConstantPool;

public class InvokeSpecialCmd extends TwoOperandCmd {

	public InvokeSpecialCmd(ClassFile clzFile, String opCode) {
		super(clzFile,opCode);
		
	}

	@Override
	public String toString(ConstantPool pool) {
		
		return super.getOperandAsMethod(pool);
	}

	

}
