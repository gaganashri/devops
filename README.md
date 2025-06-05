# devops
### ✅ Step 1: Install WSL (Windows Subsystem for Linux)

Run the following in **PowerShell as Administrator**:

```bash
wsl --install
```
✅ Step 2: Launch Ubuntu and Install Ansible
Open Ubuntu from the Start menu and run:

```bash
sudo apt update
sudo apt install ansible -y
```
✅ Step 3: Verify Ansible Installation
```bash
ansible --version
```
Step 4: Create Project Directory
```bash
mkdir ~/ansible-lab
cd ~/ansible-lab
```
Step 5: Create Inventory File
Create a file named hosts:
```
nano hosts
```
```bash
[local]
localhost ansible_connection=local
```
Create a file named install_nginx.yml:
```
nano install_ngnix.yml
```
yml file
```
---
- name: Install and start NGINX on localhost
  hosts: local
  become: yes

  tasks:
    - name: Install NGINX
      apt:
        name: nginx
        state: present
        update_cache: yes

    - name: Ensure NGINX is running
      service:
        name: nginx
        state: started
        enabled: yes
```
Run:
```
ansible-playbook -i hosts install_nginx.yml
```
Verify 
```
curl http://localhost
```


on windows 10

🚀 Ansible Lab Setup on Windows 10 using WSL2
This guide walks you through setting up WSL2 + Ubuntu + Ansible on a Windows 10 system and using Ansible to install and start NGINX locally.

✅ Step 1: Enable WSL & Virtual Machine Platform
Open PowerShell as Administrator and run:
```
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
```
🔁 Restart your computer after running the above commands.

✅ Step 2: Set WSL 2 as Default
After the restart, open PowerShell (Admin) again and run:
```
wsl --set-default-version 2
```
✅ Step 3: Install Ubuntu
Open Microsoft Store
Search for Ubuntu 22.04 LTS
Click Install
Launch it after installation and create a user account
✅ Step 4: Enable Virtualization in BIOS (if needed)
If WSL fails with an error like 0x80370102, enable virtualization:

Restart your PC

While it boots, press DEL, F2, or Esc to enter BIOS (varies by system)

Find and enable:

Intel VT-x, Intel Virtualization, or AMD-V
Save and exit BIOS

✅ Step 5: Install Ansible in Ubuntu
Launch Ubuntu from Start Menu and run:
```
sudo apt update
sudo apt install ansible -y
```
✅ Step 6: Create Ansible Lab Folder
```
mkdir ~/ansible-lab
cd ~/ansible-lab
```
✅ Step 7: Set Up Inventory File
Create a file named hosts:
```
nano hosts
```
Paste the following:
```
[local]
localhost ansible_connection=local
```
Save with Ctrl + O, then Enter, and exit with Ctrl + X.

✅ Step 8: Create Ansible Playbook to Install NGINX
Create a playbook file:
```
nano install_nginx.yml
```
Paste the following YAML:
```
---
- name: Install and start NGINX on localhost
  hosts: local
  become: yes

  tasks:
    - name: Install NGINX
      apt:
        name: nginx
        state: present
        update_cache: yes

    - name: Ensure NGINX is running
      service:
        name: nginx
        state: started
        enabled: yes
```
Save and exit.

✅ Step 9: Run the Playbook
Run the Ansible playbook:
```
ansible-playbook -i hosts install_nginx.yml
```
✅ Step 10: Verify
Open your browser and visit:
```
http://localhost
```
You should see the NGINX Welcome Page if everything worked correctly 🎉

✅ Summary
You've now:

Set up WSL2 and Ubuntu on Windows 10
Installed Ansible
Wrote and ran a playbook to install and start NGINX
You're ready to automate more with Ansible!
