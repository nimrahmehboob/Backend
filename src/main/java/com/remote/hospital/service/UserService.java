package com.remote.hospital.service;

import com.remote.hospital.entity.DTO.DoctorDTO;
import com.remote.hospital.entity.Doctor_Specialization;
import com.remote.hospital.entity.Role;
import com.remote.hospital.entity.Specialization;
import com.remote.hospital.entity.User;
import com.remote.hospital.repository.DoctorSpecializationRepository;
import com.remote.hospital.repository.SpecializationRepository;
import com.remote.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    DoctorSpecializationService doctorSpecializationService;
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }

    //login method start
    public User Login(String email, String password) {
        User user = userRepository.findByEmailAddress(email);

        return  user;

    }


    public User getUserByEmail(String email) {
        User u = new User();
        try {
             u = userRepository.findByEmailAddress(email);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return u;
    }

    @CrossOrigin
    public List<User> getDoctors() {

        return userRepository.findAll();
//
//        List<User> allUsers = userRepository.findAll().stream().filter(k->k.getRole() != null)
//                .collect(Collectors.toList());
//        List<User> inActiveDoctors = null;
//
//           List<User> Doctors = allUsers.stream().filter(k -> k.getRole().getId() == 3)
//                    .collect(Collectors.toList());

//        return  userRepository.findAll().stream().filter(u-> u.getActive() !=null && u.getActive() == false && u.getRole().getId() == 3).collect(Collectors.toList());

    }


    public List<DoctorDTO> getAllDoctorsWithAreas(){

        Role r =new Role();
        r.setId(3L);
        r.setName("Doctor");
        List<User> doctors= userRepository.findAllByIsActiveAndRole(true,r);

            List<DoctorDTO> allDoctorsInfo = new ArrayList<>();
        for (User d:
             doctors) {
                DoctorDTO doctorDTO = new DoctorDTO();
                doctorDTO.email = d.getEmailAddress();
                doctorDTO.cnic = d.getCnic();
                doctorDTO.gender = d.getGender();
                doctorDTO.name = d.getUser_name();
                doctorDTO.number = d.getPhone_number();
               List<Doctor_Specialization> doctor_specialization = doctorSpecializationRepository.findAll()
                        .stream()
                        .filter(x->x.getDoctorId() == d.getId())
                        .collect(Collectors.toList());

//            System.out.println(ds);
//            > allSpecialization=  specializationRepository.findById((d.getId()));
//            System.out.println(allSpecialization);


            List<String> areas= new ArrayList<>();
            for(int i=0;i<doctor_specialization.size();i++)
            {

                Optional<Specialization> s = specializationRepository.findById(doctor_specialization.get(i).getSpecializationId());
                areas.add(s.get().getName());
//                doctorDTO.area.add(s.get().getName());
            }
            doctorDTO.area= areas;
//            for (Specialization s:
//                 allSpecialization) {
//                doctorDTO.area.add(s.getName());
//            }
//               doctorDTO.area = allSpecialization.stream().map(x->x.getName()).collect(Collectors.toList());
                allDoctorsInfo.add(doctorDTO);
        }
        return allDoctorsInfo;



    }

    public User saveUser(User user) {
        user.setCreated_on(new Date());
        if (user.getRole()
                .getId() == 2){
            user.setIsActive(false);
        }
        else {
            user.setIsActive(true);
        }
        return userRepository.save(user);
    }

    //login method end



//    public String saveDoctor(DoctorDTO doctorDTO) {
//
//
//        User user = new User();
//        user.setUser_name(doctorDTO.name);
////        user.setAddress(doctorDTO.);
//        user.setGender(doctorDTO.gender);
//        user.setRole(3);
//            user.setCreated_on(new Date());
//            user.setGender(doctorDTO.gender);
//            user.setPhone_number(doctorDTO.number);
//
//            user.setDob(new Date(doctorDTO.dob));
////            user.setBlood_group();
//        user.setEmailAddress(doctorDTO.email);
////        user.setPassword();
//
////            user.setDob(DateTimeFormatter(doctorDTO.dob));
//        //        userRepository.save(doctorDTO);
//
//        return "";
//
//    }



//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public User findByPhoneNumber(String phoneNumber) {
//        return userRepository.findByPhoneNumber(phoneNumber);
//    }
//
//    public User findByUsernameOrEmail(String username, String email) {
//        return userRepository.findByUsernameOrEmail(username, email);
//    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }








}
