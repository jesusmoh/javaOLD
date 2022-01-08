/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.util;

import org.modelmapper.ModelMapper;

/**
 *
 * @author jesus
 */
public class MHelpers {
    
    public static ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
