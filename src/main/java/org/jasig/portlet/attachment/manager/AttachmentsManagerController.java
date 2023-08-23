/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.attachment.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.liferay.portletmvc4spring.bind.annotation.RenderMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.portlet.PortletRequest;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jasig.portlet.attachment.service.IAttachmentService;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Toben Archer
 */
@Controller
@RequestMapping("VIEW")
public class AttachmentsManagerController {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private IAttachmentService attachmentService;

    @RenderMapping
    public ModelAndView main(final PortletRequest request) {
        final Map<String,Object> model = new HashMap<String,Object>();
        model.put("attachments",attachmentService.findAll(0,65536));
        ModelAndView view = new ModelAndView("view",model);
        return view;
    }
}
